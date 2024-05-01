package com.restaurant.controller;

import com.restaurant.Repository.MenuResponseWrapper;
import com.restaurant.Repository.ResponseConstant;
import com.restaurant.Repository.ResponseWrapper;
import com.restaurant.entity.MenuEntity;
import com.restaurant.service.MenuService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.Map;


@Controller
@RequestMapping("/api/v1/menu")
@CrossOrigin("localhost:3000")
public class MenuController {

    private final Logger logger = LoggerFactory.getLogger(MenuController.class);

    @Autowired
    MenuService menuService;

    public ResponseEntity<ResponseWrapper> addMenu(Map<String, String> body){
        MenuEntity menu = new MenuEntity(body.get("name"), body.get("description"), body.get("image"), Integer.parseInt(body.get("price")));
        String additional = body.get("additional");
        menu.setAdditional(additional.trim().split("\\s*,\\s*"));

        ResponseWrapper responseWrapper = new ResponseWrapper();

        int result = menuService.addMenu(menu);
        if(result > 0){
            responseWrapper.setResponseCode(ResponseConstant.SUCCESS_CODE);
            responseWrapper.setResponseDesc(ResponseConstant.SUCCESS);
            responseWrapper.setResponseStatus(ResponseConstant.SUCCESS);
        }else {
            responseWrapper.setResponseCode(ResponseConstant.FAIL_CODE);
            responseWrapper.setResponseDesc(ResponseConstant.FAIL);
            responseWrapper.setResponseStatus("Got error while adding menu : " + menu.getName());
        }

        logger.info(responseWrapper.toString());
        ResponseEntity<ResponseWrapper> response = new ResponseEntity<>(responseWrapper, HttpStatus.OK);
        return response;
    }

    public ResponseEntity<ResponseWrapper> removeMenu(String menuName){
        ResponseWrapper responseWrapper = new ResponseWrapper();

        int result = menuService.removeMenu(menu);
        if(result>0){
            responseWrapper.setResponseCode(ResponseConstant.SUCCESS_CODE);
            responseWrapper.setResponseDesc(ResponseConstant.SUCCESS);
            responseWrapper.setResponseStatus(ResponseConstant.SUCCESS);
        }else {
            responseWrapper.setResponseCode(ResponseConstant.FAIL_CODE);
            responseWrapper.setResponseDesc(ResponseConstant.FAIL);
            responseWrapper.setResponseStatus("Got error while removing menu : " + menuName);
        }

        logger.info(responseWrapper.toString());
        ResponseEntity<ResponseWrapper> response = new ResponseEntity<>(responseWrapper, HttpStatus.OK);
        return response;
    }

    public ResponseEntity<ResponseWrapper> searchMenu(String keyword, int limit, int offset){
        MenuResponseWrapper responseWrapper = new MenuResponseWrapper();

        ResponseEntity<ResponseWrapper> menus = menuService.searchMenu(keyword, limit, offset);

        int nextOffset = offset + limit;
        int prevOffset = offset - limit;
        String path = "/restaurant-manager/searchMenu";
        String nextPage = getNextPageForSearchResult(keyword, limit, nextOffset, path);
        String prevPage = getPrevPage(limit, prevOffset, path);

        responseWrapper.setMenus((List<MenuEntity>) menus);
        responseWrapper.setNextPage(nextPage);
        responseWrapper.setPreviousPage(prevPage);
        responseWrapper.setResponseCode(ResponseConstant.SUCCESS_CODE);
        responseWrapper.setResponseStatus(ResponseConstant.SUCCESS);
        responseWrapper.setResponseDesc(ResponseConstant.SUCCESS);

        logger.info(responseWrapper.toString());
        ResponseEntity<ResponseWrapper> response = new ResponseEntity<>(responseWrapper, HttpStatus.OK);
        return response;
    }

    public ResponseEntity<ResponseWrapper> getAllMenu(int limit, int offset){
        MenuResponseWrapper responseWrapper = new MenuResponseWrapper();

        ResponseEntity menus = menuService.getAllMenu(limit, offset);

        int nextOffset = offset + limit;
        int prevOffset = offset - limit;
        String path = "/restaurant-manager/getAllMenu";
        String nextPage = getNextPage(limit, nextOffset, path);
        String prevPage = getPrevPage(limit, prevOffset, path);

        responseWrapper.setMenus((List<MenuEntity>) menus);
        responseWrapper.setNextPage(nextPage);
        responseWrapper.setPreviousPage(prevPage);
        responseWrapper.setResponseCode(ResponseConstant.SUCCESS_CODE);
        responseWrapper.setResponseStatus(ResponseConstant.SUCCESS);
        responseWrapper.setResponseDesc(ResponseConstant.SUCCESS);

        logger.info(responseWrapper.toString());
        ResponseEntity<ResponseWrapper> response = new ResponseEntity<>(responseWrapper, HttpStatus.OK);
        return response;
    }

    public String getNextPageForSearchResult(String keyword, int limit, int nextOffset, String path){
        String nextPage = null;
        if (menuService.hasNextPageForKeyword(keyword, nextOffset)){
            nextPage = path + "?limit=" + limit + "&offset=" + nextOffset;
        }
        return nextPage;
    }

    public String getNextPage(int limit, int nextOffset, String path){
        String nextPage = null;
        if (menuService.hasNextPage(nextOffset)){
            nextPage = path + "?limit=" + limit + "&offset=" + nextOffset;
        }
        return nextPage;
    }

    public String getPrevPage(int limit, int prevOffset, String path){
        String prevPage = null;
        if (prevOffset >= 0){
            prevPage = path + "?limit=" + limit + "&offset=" + prevOffset;
        }
        return prevPage;
    }
}
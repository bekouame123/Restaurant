package com.restaurant.controller;

import java.util.List;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.restaurant.entity.MenuEntity;

import com.restaurant.service.MenuService;

import ch.qos.logback.classic.Logger;

@RestController
@RequestMapping("/api/v1/menu")
public class MenuController{

    @Autowired
    MenuService menuService;
    
    @PostMapping("/addMenu")
    public void addMenu(@RequestBody MenuEntity menu){
         menuService.addMenu(menu);
    }


    @GetMapping("/menu")
    public List<MenuEntity> findAllMenu(){
        return menuService.getAll();
    }
	
    @GetMapping("/searchMenu/{id}")
    public void searchMenuById(@PathVariable("id") Long id){
        menuService.searchMenuById(id);
    }

    @DeleteMapping("/{id}")
    public void removeMenuById(@PathVariable("id") Long id){
         menuService.removeMenuById(id);
    }
    
    @PutMapping("/{id}")
    public void updateMenubyEntity(@PathVariable("id")Long id, @RequestBody MenuEntity menuEntity) {
    	menuService.updateMenuBy(id,menuEntity);
    		
    
    }
}
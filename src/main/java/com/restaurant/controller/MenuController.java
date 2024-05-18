package com.restaurant.controller;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.restaurant.entity.MenuEntity;
import com.restaurant.service.MenuService;

@RestController
@RequestMapping("/api/v1")
@CrossOrigin("http://localhost:3000")
public class MenuController{

    @Autowired
    MenuService menuService;
    
    @PostMapping("/add")
    public void addMenu(@RequestBody MenuEntity menu){
         menuService.addMenu(menu);
    }


    @GetMapping("/all")
    public List<MenuEntity> findAllMenu(){
        return menuService.getAll();
    }
	
    @GetMapping("/searchMenu/{id}")
    public void searchMenuById(@PathVariable("id") Long id){
        menuService.searchMenuById(id);
    }

    @DeleteMapping("remove/{id}")
    public void removeMenuById(@PathVariable("id") Long id){
         menuService.removeMenuById(id);
    }
    
    @PutMapping("update/{id}")
    public void updateMenubyEntity(@PathVariable("id")Long id, @RequestBody MenuEntity menuEntity) {
    	menuService.updateMenuBy(id,menuEntity);
    		
    }


}
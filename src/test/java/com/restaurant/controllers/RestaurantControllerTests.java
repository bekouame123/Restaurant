package com.restaurant.controllers;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;

import com.restaurant.controller.MenuController;
import com.restaurant.entity.MenuEntity;
import com.restaurant.entity.OrderEntity;
import com.restaurant.service.MenuService;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import  org.mockito.Mockito.*;


@ExtendWith(MockitoExtension.class)
public class RestaurantControllerTests {

	
	

	@Mock //mocked dependency
	private MenuService menuService;
	
	@InjectMocks //Class under test that will take the mocks
	private MenuController menuController;

	
	
//    @Test
//     void searchMenuById() {
//    	 when(menuService.getMenu(1L))
//    	        .thenReturn(new MenuEntity(1L, "Vietnamese soupe", "Schrimp", "456123", 30,
//                		new OrderEntity(2L, "34575",4,"2022-05-26")));
//    	 
//    	 var getIdSearch = menuController.searchMenuById(1L);
//		assertTrue(getIdSearch.);
//    }
 
    @Test
    void createMenu() {
        var menu = new MenuEntity(2L, "Vietnamese Grill", "Snails", "456123", 35,
        		new OrderEntity(2L, "34575",4,"2022-05-26"));
        doNothing().when(menuService).addMenu(menu);

        menuController.addMenu(menu);
        verify(menuService, times(1)).addMenu(menu);

    }

    @Test
    void findAllMenu() {

        List<MenuEntity> menus = new ArrayList<>();
        menus.add(new MenuEntity(1L, "Italian", "Pasta", "123456", 25, new OrderEntity(1L, "12345",2,"2024-04-30")));
        menus.add(new MenuEntity(2L, "Indian", "Rice", "654321", 27, new OrderEntity(2L, "34575",4,"2022-05-26")));

     
		when(menuService.getAll()).thenReturn(menus);

        
		List<MenuEntity> returnedMenus = menuController.findAllMenu();
		assertNotNull(returnedMenus);
        assertFalse(returnedMenus.isEmpty());
        assertEquals(2, returnedMenus.size());

    }


   

//	@Test
//    void updatebyId() {
//        MenuEntity menu = new MenuEntity(1L, "Vietnamese soupe", "Schrimp", "456123", 30,
//                new OrderEntity(1L, "12345",2,"2024-04-30"));
//
//       
//        doNothing().when(menuService).addMenu(menu);
//        verify(menuService, times(1)).addMenu( menu);
// 
//	}

    
    @Test
    void deletebyId() {
        MenuEntity menu = new MenuEntity(1L,  "Vietnamese soupe", "Schrimp", "456123", 30,
                new OrderEntity(1L, "12345",2,"2024-04-30"));
        doNothing().when(menuService).removeMenuById(1L);
        
        menuController.removeMenuById(1L);
        verify(menuService, times(1)).removeMenuById(1L);
    

}}
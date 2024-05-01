package com.restaurant.controller;

import java.awt.Menu;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.restaurant.entity.OrderEntity;
import com.restaurant.service.MenuService;
import com.restaurant.service.OrderService;

import ch.qos.logback.classic.Logger;

@RestController
@RequestMapping("/api/v1/menu")
public class OrderController{

	private static final int OrderEntity = 0;


	private final Logger logger = null;


	@Autowired
	private OrderService orderService;

	@PostMapping("/addOrder")
	public void addOrder(@RequestBody OrderEntity order){
     orderService.addOrder(order);
}


	@GetMapping("/order")
	public List<OrderEntity> findAllOrder(){
		return orderService.getAll();
	}
    
    @GetMapping("/saveOrder")
    public List<OrderEntity> saveOrder(@RequestBody OrderEntity order){
    	return orderService.getOrder();
    	
    }
    
    @PutMapping("/{id}")
	public List<OrderEntity> updateOrder( @RequestBody OrderEntity oeder){
	       return OrderService.updateMenu();
			
		}
   
	@DeleteMapping("/{id}")
	 public String LideleteOrder(@PathVariable Long id){
	         orderService.deleteOrder();
	         return "your order is delete with suceess";
	      }
	  }

	  
	     
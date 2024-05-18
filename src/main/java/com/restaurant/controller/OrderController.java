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

import com.restaurant.entity.OrderEntity;
import com.restaurant.service.OrderService;



@RestController
@RequestMapping("/api/v1/order")
@CrossOrigin("http://localhost:3000")
public class OrderController{

	
	@Autowired
	private OrderService orderService;

	@PostMapping("/add")
	public void addOrder(@RequestBody OrderEntity order){
		
     orderService.addOrder(order);
}


	@GetMapping("/all")
	public List<OrderEntity> findAllOrder(){
		return orderService.getAll();
	}
    

    @PutMapping("update/order/{id}")
    public void updateMenubyEntity(@PathVariable("id")Long id, @RequestBody OrderEntity order) {
    	orderService.updateOrder(id,order);
    		
    
    }
   
	@DeleteMapping("delete/order/{id}")
	 public String deleteOrder(@PathVariable Long id){
	         orderService.deleteOrder(id);
	         return "your order is delete with suceess";
	      }

    @GetMapping("/orderSeacher/{id}")
    public void orderSeacherById(@PathVariable("id") Long id){
    	orderService.searchMenuById(id);
    }


	
}

	  
	     
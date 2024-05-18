package com.restaurant.service;

import java.awt.Menu;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import com.restaurant.entity.OrderEntity;
import com.restaurant.repository.OrderRepository;

import jakarta.persistence.OrderBy;


@Service
public class OrderService{
	
	@Autowired
	private static OrderRepository orderRepository;
	
    
	public void addOrder(OrderEntity order) {
		orderRepository.save(order);
		
	}

	public List<OrderEntity> getAll() {
		return orderRepository.findAll();
	}


	public void updateOrder(Long id, OrderEntity order) {
		Optional<OrderEntity> repoOrder = orderRepository.findById(id);
	     BeanUtils.copyProperties(repoOrder, order);
	     orderRepository.save(order);	
	}

	public void deleteOrder(Long id) {
		 orderRepository.deleteById(id);
	}



	public void searchMenuById(Long id) {
		orderRepository.findById(id);
	}
		

	
	
}
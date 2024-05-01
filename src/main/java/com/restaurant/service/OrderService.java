package com.restaurant.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.restaurant.entity.OrderEntity;
import com.restaurant.repository.OrderRepository;


@Service
public class OrderService{
	
	@Autowired
	private OrderRepository orderRepository;

    
	public void addOrder(OrderEntity order) {
		orderRepository.save(order);
		
	}

	public List<OrderEntity> getAll() {
		return (List<OrderEntity>) orderRepository.findAll();
	}

	public List<OrderEntity> getOrder() {
		// TODO Auto-generated method stub
		return null;
	}

	public static List<OrderEntity> updateMenu() {
		// TODO Auto-generated method stub
		return null;
	}

	public List<OrderEntity> deleteOrder() {
		// TODO Auto-generated method stub
		return null;
	}
	
}
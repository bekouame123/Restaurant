package com.restaurant.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.restaurant.entity.CustomerEntity;
import com.restaurant.service.CustomerService;

import ch.qos.logback.classic.Logger;

@RestController
@RequestMapping("/api/v1/customer")
public class CustomerController{

    private final Logger logger = null;

    @Autowired
    CustomerService customerService;
    
    @PostMapping("/addCustomer")
    public void addCustomer(@RequestBody CustomerEntity order){
         Object customer = null;
		customerService.addCustomer(customer);
    }


    @GetMapping("/customer")
    public List<CustomerEntity> findAll(){
        return customerService.getAll();
    }
}
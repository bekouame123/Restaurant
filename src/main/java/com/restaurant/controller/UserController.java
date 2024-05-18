//package com.restaurant.controller;
//
//import java.util.List;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//import com.restaurant.entity.UserEntity;
//import com.restaurant.service.UserService;
//
//import ch.qos.logback.classic.Logger;
//
//@RestController
//@RequestMapping("/api/v1/user")
//public class UserController{
//
//    private final Logger logger = null;
//
//    @Autowired
//    UserService userService;
//    
//    @PostMapping("/addUser")
//    public void addCustomer(@RequestBody UserEntity order){
//         Object user = null;
//		userService.addCustomer(user);
//    }
//
//
//    @GetMapping("/user")
//    public List<UserEntity> findAll(){
//        return userService.getAll();
//    }
//}
package com.cotiviti.ecom.controller;

import com.cotiviti.ecom.model.User;
import com.cotiviti.ecom.service.UserService;
import com.cotiviti.ecom.service.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserController {

    @Autowired
    UserServiceImpl userService;

    @PostMapping("/user/add")
    public User addUser(@RequestBody User user){
        return userService.saveUser(user);
    }

}

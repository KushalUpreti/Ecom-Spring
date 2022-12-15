package com.cotiviti.ecom.controller;

import com.cotiviti.ecom.model.User;
import com.cotiviti.ecom.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserController {

    @Autowired
    UserService userService;

    @PostMapping("/user/add")
    public String addUser(@RequestBody User user){
        User userReturn = userService.saveUser(user);
        System.out.println(userReturn);
        return "I'm home";
    }

}

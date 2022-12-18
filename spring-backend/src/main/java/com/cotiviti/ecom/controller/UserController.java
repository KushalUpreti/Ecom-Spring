package com.cotiviti.ecom.controller;

import com.cotiviti.ecom.dto.UserDTO;
import com.cotiviti.ecom.model.User;
import com.cotiviti.ecom.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/user/")
public class UserController {

    @Autowired
    UserService userService;

    @PostMapping("/add")
    public ResponseEntity<UserDTO> addUser(@RequestBody UserDTO userDto) {
        UserDTO createUserDTO = userService.saveUser(userDto);
        return new ResponseEntity<>(createUserDTO, HttpStatus.CREATED);
    }

    @GetMapping("/")
    public ResponseEntity<List<UserDTO>> getAllusers(){
        List<UserDTO> allUsers = userService.getAllUsers ();
        return new ResponseEntity<> (allUsers, HttpStatus.OK );
    }
}

package com.cotiviti.ecom.service;

import com.cotiviti.ecom.dto.UserDTO;

import java.util.List;

public interface UserService {

    UserDTO saveUser(UserDTO user);
    List<UserDTO> getAllUsers();

}

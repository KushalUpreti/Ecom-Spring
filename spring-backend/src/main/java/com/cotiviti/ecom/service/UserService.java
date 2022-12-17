package com.cotiviti.ecom.service;

import com.cotiviti.ecom.model.Address;
import com.cotiviti.ecom.model.User;

import java.util.List;

public interface UserService {

     User saveUser(User user);
     List<Address> getUserAddresses();
}

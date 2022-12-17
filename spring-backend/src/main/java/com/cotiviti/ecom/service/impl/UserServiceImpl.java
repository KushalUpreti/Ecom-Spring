package com.cotiviti.ecom.service.impl;

import com.cotiviti.ecom.model.Address;
import com.cotiviti.ecom.model.User;
import com.cotiviti.ecom.repository.UserRepository;
import com.cotiviti.ecom.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository;

    @Override
    public User saveUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public List<Address> getUserAddresses() {
        return null;
    }
}

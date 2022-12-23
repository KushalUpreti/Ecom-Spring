package com.cotiviti.ecom.service.impl;

import com.cotiviti.ecom.dto.CartDTO;
import com.cotiviti.ecom.exception.ResourceNotFoundException;
import com.cotiviti.ecom.model.Cart;
import com.cotiviti.ecom.model.User;
import com.cotiviti.ecom.repository.CartRepository;
import com.cotiviti.ecom.repository.UserRepository;
import com.cotiviti.ecom.service.CartService;
import com.cotiviti.ecom.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



@Service
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {

    private final CartService cartService;
    private final UserRepository userRepository;
    private final CartRepository cartRepository;

    @Override
    public void placeOrder(Integer user_id) {
        cartService.terminateSession(user_id);
        User user = userRepository.findById(user_id)
                .orElseThrow(() -> new ResourceNotFoundException("User", "userId", user_id));

        Cart newCart = new Cart();
        newCart.setUser(user);
        newCart.setActiveSession(true);
        cartRepository.save(newCart);
    }
}

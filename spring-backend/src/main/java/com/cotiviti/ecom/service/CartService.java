package com.cotiviti.ecom.service;

import com.cotiviti.ecom.dto.CartDTO;

public interface CartService {
    CartDTO createCart(CartDTO cartDTO);

    //    CartDTO updatePrice(Double newPrice,Integer user_id);
    void terminateSession(Integer user_id);
}

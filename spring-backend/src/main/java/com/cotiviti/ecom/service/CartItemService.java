package com.cotiviti.ecom.service;

import com.cotiviti.ecom.dto.CartItemDTO;
import com.cotiviti.ecom.projection.CartItemProjection;

import java.util.List;

public interface CartItemService {

    CartItemDTO addItemToCart(CartItemDTO cartItemDTO, Integer itemId, Integer userId);

    int removeItemFromCart(Integer cartItemId);

    CartItemDTO updateQuantity(Integer cartItemId, Integer quantity);

    List<CartItemProjection> getAllCartItems(Integer userId);

    int getCartItemCount(Integer userId);
}

package com.cotiviti.ecom.service;

import com.cotiviti.ecom.dto.CartItemDTO;

import java.util.List;

public interface CartItemService {

    CartItemDTO addItemToCart(CartItemDTO cartItemDTO, Integer itemId, Integer userId);

    void removeItemFromCart(Integer cartItemId);

    CartItemDTO updateQuantity(Integer cartItemId, Integer quantity);

    List<CartItemDTO> getAllCartItems(Integer userId);

    int getCartItemCount(Integer userId);
}

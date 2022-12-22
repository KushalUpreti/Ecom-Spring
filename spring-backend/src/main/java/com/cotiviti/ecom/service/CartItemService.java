package com.cotiviti.ecom.service;

import com.cotiviti.ecom.dto.CartItemDTO;
import com.cotiviti.ecom.dto.CustomDTO;
import com.cotiviti.ecom.model.CartItem;

import java.util.List;

public interface CartItemService {

    CartItemDTO addItemToCart(CartItemDTO cartItemDTO, Integer itemId, Integer userId);

    int removeItemFromCart(Integer cartItemId);

    CartItemDTO updateQuantity(Integer cartItemId, Integer quantity);

    List<CustomDTO> getAllCartItems(Integer userId);

    int getCartItemCount(Integer userId);
}

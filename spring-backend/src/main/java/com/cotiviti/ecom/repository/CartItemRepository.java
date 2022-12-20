package com.cotiviti.ecom.repository;

import com.cotiviti.ecom.model.Cart;
import com.cotiviti.ecom.model.CartItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CartItemRepository extends JpaRepository<CartItem, Integer> {
    long countByCart(Cart cart);
}

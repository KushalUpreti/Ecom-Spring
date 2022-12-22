package com.cotiviti.ecom.repository;

import com.cotiviti.ecom.dto.CustomDTO;
import com.cotiviti.ecom.model.CartItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.sql.ResultSet;
import java.util.List;

public interface CartItemRepository extends JpaRepository<CartItem, Integer> {
    @Query("SELECT m.quantity as quantity, m.id, i.title, i.price FROM CartItem m JOIN Item i ON m.item = i.id JOIN Cart c on c.id=m.cart WHERE c.id = :cart_id")
    List findByNamedParams(@Param("cart_id") Integer cart_id);
}

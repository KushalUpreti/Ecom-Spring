package com.cotiviti.ecom.repository;

import com.cotiviti.ecom.dto.CustomDTO;
import com.cotiviti.ecom.model.CartItem;
import com.cotiviti.ecom.projection.CartItemProjection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.sql.ResultSet;
import java.util.List;

public interface CartItemRepository extends JpaRepository<CartItem, Integer> {
    @Query(value = "SELECT m.quantity, m.id, i.title, i.price FROM cart_items m JOIN Items i ON m.item_id = i.id JOIN Carts c on c.id=m.cart_id WHERE c.id = ?1",nativeQuery = true)
    List<CartItemProjection> findByNamedParams(@Param("cart_id") Integer cart_id);
}

package com.cotiviti.ecom.repository;

import com.cotiviti.ecom.model.Cart;
import com.cotiviti.ecom.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface CartRepository extends JpaRepository<Cart, Integer> {

    Cart findByActiveSessionAndUser(boolean activeSession, User user);


}

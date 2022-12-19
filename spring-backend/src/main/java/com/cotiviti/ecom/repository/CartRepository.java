package com.cotiviti.ecom.repository;

import com.cotiviti.ecom.model.Cart;
import com.cotiviti.ecom.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CartRepository extends JpaRepository<Cart, Integer> {
    //    @Query("SELECT c FROM Carts c WHERE c.active_session = true")
//    Cart findByActiveSession();
    Cart findByActiveSessionAndUser(boolean activeSession, User user);
}

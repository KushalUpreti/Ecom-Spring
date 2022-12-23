package com.cotiviti.ecom.controller;

import com.cotiviti.ecom.dto.StringResponseDTO;
import com.cotiviti.ecom.projection.CartItemProjection;
import com.cotiviti.ecom.service.CartItemService;
import com.cotiviti.ecom.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/order")
public class OrderController {

    @Autowired
    OrderService orderService;

    @Autowired
    CartItemService cartItemService;

    @PostMapping("placeOrder/{userId}")
    public ResponseEntity<StringResponseDTO> placeOrder(
            @PathVariable("userId") Integer userId
    ) {
//        List<CartItemProjection> cartItemscartItemService.getAllCartItems(userId);
        orderService.placeOrder(userId);
        return new ResponseEntity<>(new StringResponseDTO("Order Added",200), HttpStatus.OK);
    }
}

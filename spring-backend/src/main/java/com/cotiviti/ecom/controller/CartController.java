package com.cotiviti.ecom.controller;

import com.cotiviti.ecom.dto.CartItemDTO;
import com.cotiviti.ecom.service.CartItemService;
import com.cotiviti.ecom.service.CartService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/cart")
public class CartController {

    @Autowired
    CartService cartService;

    @Autowired
    CartItemService cartItemService;

//    @PutMapping("/updatePrice")
//    public ResponseEntity<CartDTO> updateCartPrice(
//            @PathVariable("price") Double price,
//            @PathVariable("userId") Integer userId) {
//        CartDTO createdCartDTO = cartService.updatePrice(price, userId);
//        return new ResponseEntity<>(createdCartDTO, HttpStatus.OK);
//    }

    @PostMapping("/addItem/{itemId}/{userId}")
    public ResponseEntity<String> addItem(
            @Valid @RequestBody CartItemDTO cartItemDTO,
            @PathVariable("itemId") Integer itemId,
            @PathVariable("userId") Integer userId
    ) {
        CartItemDTO dto = cartItemService.addItemToCart(cartItemDTO, itemId, userId);
//        TODO: Fix response not being sent error
        return new ResponseEntity<>("Item added", HttpStatus.CREATED);

    }

    @DeleteMapping("/deleteItem/{itemId}")
    public ResponseEntity<String> deleteItem(
            @PathVariable("itemId") Integer itemId
    ) {
        cartItemService.removeItemFromCart(itemId);
        return new ResponseEntity<>("Item deleted", HttpStatus.OK);
    }


}

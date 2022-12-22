package com.cotiviti.ecom.controller;

import com.cotiviti.ecom.dto.CartItemDTO;
import com.cotiviti.ecom.dto.CustomDTO;
import com.cotiviti.ecom.dto.StringResponseDTO;
import com.cotiviti.ecom.model.CartItem;
import com.cotiviti.ecom.service.CartItemService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/cart")
public class CartController {
    //        TODO: Fix response not being sent error
    @Autowired
    CartItemService cartItemService;

    @PostMapping("/addCartItem/{itemId}/{userId}")
    public ResponseEntity<StringResponseDTO> addItem(
            @Valid @RequestBody CartItemDTO cartItemDTO,
            @PathVariable("itemId") Integer itemId,
            @PathVariable("userId") Integer userId
    ) {
        cartItemService.addItemToCart(cartItemDTO, itemId, userId);
        return new ResponseEntity<>(new StringResponseDTO("Item Added",200), HttpStatus.OK);
    }

    @DeleteMapping("/deleteCartItem/{itemId}")
        public ResponseEntity<Integer> deleteItem(
            @PathVariable("itemId") Integer itemId
    ) {
        int itemQuantity = cartItemService.removeItemFromCart(itemId);
        return new ResponseEntity<>(itemQuantity, HttpStatus.OK);
    }

    @GetMapping("/getCartItems/{userId}")
    public ResponseEntity<List<CustomDTO>> getCartItems(
            @PathVariable("userId") Integer userId
    ) {
        List<CustomDTO> cartItemDTOS = cartItemService.getAllCartItems(userId);
        return new ResponseEntity<>(cartItemDTOS, HttpStatus.OK);
    }

    @GetMapping("/getCartItemCount/{userId}")
    public ResponseEntity<Integer> getCartItemCount(
            @PathVariable("userId") Integer userId
    ) {
        int cartItemCount = cartItemService.getCartItemCount(userId);
        return new ResponseEntity<>(cartItemCount, HttpStatus.OK);
    }
}

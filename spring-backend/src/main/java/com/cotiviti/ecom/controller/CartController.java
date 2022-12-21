package com.cotiviti.ecom.controller;

import com.cotiviti.ecom.dto.CartItemDTO;
import com.cotiviti.ecom.dto.StringResponseDTO;
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
    public ResponseEntity<String> deleteItem(
            @PathVariable("itemId") Integer itemId
    ) {
        cartItemService.removeItemFromCart(itemId);
        return new ResponseEntity<>("Item deleted", HttpStatus.OK);
    }

    @PutMapping("/updateCartItemQuantity/{cartItemId}/{quantity}")
    public ResponseEntity<CartItemDTO> updateQuantity(
            @PathVariable("cartItemId") Integer cartItemId,
            @PathVariable("quantity") Integer quantity) {
        CartItemDTO dto = cartItemService.updateQuantity(cartItemId, quantity);
        return new ResponseEntity<>(dto, HttpStatus.OK);
    }

    @GetMapping("/getCartItems/{userId}")
    public ResponseEntity<List<CartItemDTO>> getCartItems(
//            public ResponseEntity<String> getCartItems(
            @PathVariable("userId") Integer userId
    ) {
        List<CartItemDTO> cartItemDTOS = cartItemService.getAllCartItems(userId);
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

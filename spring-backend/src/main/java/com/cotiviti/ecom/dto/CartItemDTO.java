package com.cotiviti.ecom.dto;

import com.cotiviti.ecom.model.Cart;
import com.cotiviti.ecom.model.Item;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor

public class CartItemDTO {

    private int id;

    private Item item;

    private Cart cart;

    private int quantity;

    private LocalDateTime created_at;

    private LocalDateTime updated_at;

}

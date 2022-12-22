package com.cotiviti.ecom.dto;

import lombok.*;

@Data
@NoArgsConstructor

public class CustomDTO {
    private int id;
    private String title;
    private int quantity;
    private double price;
}

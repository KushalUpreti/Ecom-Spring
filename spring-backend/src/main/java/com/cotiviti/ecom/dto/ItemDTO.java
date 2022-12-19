package com.cotiviti.ecom.dto;

import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class ItemDTO {

    private int id;

    private CategoryDTO category;

    @NotEmpty
    private String title;

    @NotEmpty
    @Size( max = 500, message = "Description must be 500 characters maximum")
    private String description;

    @DecimalMin(value = "0.0")
    private double price;

    private LocalDateTime created_at;

    private LocalDateTime updated_at;

}

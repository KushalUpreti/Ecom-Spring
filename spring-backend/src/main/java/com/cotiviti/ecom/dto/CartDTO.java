package com.cotiviti.ecom.dto;

import com.cotiviti.ecom.model.User;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotEmpty;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class CartDTO {

    private int id;

    private User user;

    @NotEmpty
    private boolean activeSession = false;

    @DecimalMin(value = "0.0")
    private double total;

    private LocalDateTime created_at;

    private LocalDateTime updated_at;

}

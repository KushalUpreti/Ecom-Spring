package com.cotiviti.ecom.dto;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class StringResponseDTO {
    private String message;
    private int status;
}

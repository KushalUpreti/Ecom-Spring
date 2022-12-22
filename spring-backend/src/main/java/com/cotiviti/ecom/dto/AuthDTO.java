package com.cotiviti.ecom.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class AuthDTO {
    private String token;
    private String email;
    private String role;
    private int id;
}

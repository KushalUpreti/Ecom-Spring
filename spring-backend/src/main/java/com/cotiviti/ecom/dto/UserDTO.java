package com.cotiviti.ecom.dto;


import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@NoArgsConstructor
public class UserDTO {

    private int id;

    private String username;

    @Email(message = "Invalid Email")
    private String email;

    @NotEmpty
    @Size(min=3, max=12, message = "Password must be more that 3 letters and less than 12 letters")
    private String password;
}

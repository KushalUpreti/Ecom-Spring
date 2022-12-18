package com.cotiviti.ecom.dto;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class AddressDTO {

    private int id;

    private UserDTO user;

    @NotEmpty
    private String title;

    @NotEmpty
    @Size(min = 3, max = 100, message = "Street address must be min of 3 characters")
    private String streetAddress;

    @NotEmpty
    private String city;

    @NotEmpty
    private String country;

    @Override
    public String toString() {
        return "AddressDTO{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", streetAddress='" + streetAddress + '\'' +
                ", city='" + city + '\'' +
                ", country='" + country + '\'' +
                '}';
    }
}

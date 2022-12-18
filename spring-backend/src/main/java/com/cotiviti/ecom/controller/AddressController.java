package com.cotiviti.ecom.controller;

import com.cotiviti.ecom.dto.AddressDTO;
import com.cotiviti.ecom.service.AddressService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/address")
public class AddressController {

    @Autowired
    AddressService addressService;

    @PostMapping("/add/{user_id}")
    public ResponseEntity<AddressDTO> addAddress(
            @Valid @RequestBody AddressDTO addressDTO,
            @PathVariable("user_id") Integer userId) {
        System.out.println(addressDTO + " user_id " + userId);
        AddressDTO createdAddressDTO = addressService.saveAddress(addressDTO,userId);
        return new ResponseEntity<>(createdAddressDTO, HttpStatus.CREATED);
    }

}

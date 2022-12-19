package com.cotiviti.ecom.controller;

import com.cotiviti.ecom.dto.AddressDTO;
import com.cotiviti.ecom.service.AddressService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/address")
public class AddressController {

    @Autowired
    AddressService addressService;

    @PostMapping("/add/{userId}")
    public ResponseEntity<AddressDTO> addAddress(
            @Valid @RequestBody AddressDTO addressDTO,
            @PathVariable("userId") Integer userId) {
        AddressDTO createdAddressDTO = addressService.saveAddress(addressDTO, userId);
        return new ResponseEntity<>(createdAddressDTO, HttpStatus.CREATED);
    }

    @GetMapping("/{user_id}")
    public ResponseEntity<List<AddressDTO>> getUserAddresses(@PathVariable("user_id") Integer userId) {
        List<AddressDTO> addressDTOList = addressService.getAllAddresses(userId);
        return new ResponseEntity<>(addressDTOList, HttpStatus.CREATED);
    }

    @DeleteMapping("/delete/{addressId}")
    public ResponseEntity<String> deleteAddress(@PathVariable("addressId") Integer addressId) {
        addressService.deleteAddress(addressId);
        return new ResponseEntity<>("Address deleted", HttpStatus.ACCEPTED);
    }

}

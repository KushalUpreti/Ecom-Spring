package com.cotiviti.ecom.controller;

import com.cotiviti.ecom.model.Address;
import com.cotiviti.ecom.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AddressController {

    @Autowired
    AddressService addressService;

    @PostMapping("/address/add")
    public Address addAddress(@RequestBody Address address){
        System.out.println(address);
        return  addressService.saveAddress(address);
    }
}

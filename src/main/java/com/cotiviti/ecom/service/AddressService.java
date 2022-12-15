package com.cotiviti.ecom.service;

import com.cotiviti.ecom.model.Address;
import com.cotiviti.ecom.repository.AddressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AddressService {

    @Autowired
    AddressRepository addressRepository;

    public Address saveAddress(Address address){
        return addressRepository.save(address);
    }
}

package com.cotiviti.ecom.service.impl;

import com.cotiviti.ecom.model.Address;
import com.cotiviti.ecom.repository.AddressRepository;
import com.cotiviti.ecom.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AddressServiceImpl implements AddressService {
    @Autowired
    AddressRepository addressRepository;

    @Override
    public Address saveAddress(Address address) {
        return addressRepository.save(address);
    }
}

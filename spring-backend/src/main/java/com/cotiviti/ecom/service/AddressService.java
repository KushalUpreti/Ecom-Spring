package com.cotiviti.ecom.service;

import com.cotiviti.ecom.dto.AddressDTO;

import java.util.List;

public interface AddressService {

    AddressDTO saveAddress(AddressDTO address, Integer userId);

    List<AddressDTO> getAllAddresses(Integer userId);

    void deleteAddress(Integer addressId);
}

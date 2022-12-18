package com.cotiviti.ecom.service.impl;

import com.cotiviti.ecom.dto.AddressDTO;
import com.cotiviti.ecom.exception.ResourceNotFoundException;
import com.cotiviti.ecom.model.Address;
import com.cotiviti.ecom.model.User;
import com.cotiviti.ecom.repository.AddressRepository;
import com.cotiviti.ecom.repository.UserRepository;
import com.cotiviti.ecom.service.AddressService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AddressServiceImpl implements AddressService {

    private final UserRepository userRepository;
    private final AddressRepository addressRepository;
    private final ModelMapper modelMapper;

    @Override
    public AddressDTO saveAddress(AddressDTO addressDTO, Integer userId) {
        User user = userRepository
                        .findById(userId)
                        .orElseThrow(() -> new ResourceNotFoundException("User", "userId", userId));
        Address address = dtoToAddress(addressDTO);
//        user.setPassword("N/A");
//        address.setUser(user);
        Address saved = addressRepository.save(address);
        return addressToDTO(saved);
    }

    @Override
    public List<AddressDTO> getAllAddresses(Integer userId) {
        return null;
    }

    private Address dtoToAddress(AddressDTO addressDTO) {
        return modelMapper.map(addressDTO, Address.class);
    }

    private AddressDTO addressToDTO(Address address) {
        return modelMapper.map(address, AddressDTO.class);
    }
}

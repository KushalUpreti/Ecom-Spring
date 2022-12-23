package com.cotiviti.ecom.service.impl;

import com.cotiviti.ecom.dto.CartDTO;
import com.cotiviti.ecom.exception.ResourceNotFoundException;
import com.cotiviti.ecom.model.Cart;
import com.cotiviti.ecom.model.User;
import com.cotiviti.ecom.repository.CartRepository;
import com.cotiviti.ecom.repository.UserRepository;
import com.cotiviti.ecom.service.CartService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CartServiceImpl implements CartService {

    private final CartRepository cartRepository;
    private final UserRepository userRepository;
    private final ModelMapper modelMapper;

    @Override
    public CartDTO createCart(CartDTO cartDTO) {
        Cart cart = dtoToClass(cartDTO);
        Cart saved = cartRepository.save(cart);
        return classToDTO(saved);
    }

//    public CartDTO updatePrice(Double newPrice,Integer user_id) {
//        Cart cart = cartRepository.findByActiveSessionAndUser(true,user_id);
//        cart.setTotal(newPrice);
//        Cart saved = cartRepository.save(cart);
//        return classToDTO(saved);
//    }

    @Override
    public void terminateSession(Integer user_id) {
        User user = userRepository.findById(user_id)
                .orElseThrow(() -> new ResourceNotFoundException("User", "userId", user_id));
        Cart cart = cartRepository.findByActiveSessionAndUser(true,user);
        cart.setActiveSession(false);
        cartRepository.save(cart);
    }

    private Cart dtoToClass(CartDTO dto) {
        return modelMapper.map(dto, Cart.class);
    }

    private CartDTO classToDTO(Cart item) {
        return modelMapper.map(item, CartDTO.class);
    }

}

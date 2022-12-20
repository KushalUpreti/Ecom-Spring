package com.cotiviti.ecom.service.impl;

import com.cotiviti.ecom.dto.CartItemDTO;
import com.cotiviti.ecom.exception.ResourceNotFoundException;
import com.cotiviti.ecom.model.Cart;
import com.cotiviti.ecom.model.CartItem;
import com.cotiviti.ecom.model.Item;
import com.cotiviti.ecom.model.User;
import com.cotiviti.ecom.repository.CartItemRepository;
import com.cotiviti.ecom.repository.CartRepository;
import com.cotiviti.ecom.repository.ItemRepository;
import com.cotiviti.ecom.repository.UserRepository;
import com.cotiviti.ecom.service.CartItemService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor

public class CartItemServiceImpl implements CartItemService {
    private final ModelMapper modelMapper;
    private final CartRepository cartRepository;
    private final ItemRepository itemRepository;
    private final CartItemRepository cartItemRepository;
    private final UserRepository userRepository;

    @Override
    public CartItemDTO addItemToCart(CartItemDTO cartItemDTO, Integer itemId, Integer userId) {
        Item item = itemRepository.findById(itemId)
                .orElseThrow(() -> new ResourceNotFoundException("Item", "itemId", itemId));
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new ResourceNotFoundException("User", "userId", userId));
        Cart cart = cartRepository.findByActiveSessionAndUser(true, user);
        CartItem cartItem = dtoToCartItem(cartItemDTO);
        cartItem.setCart(cart);
        cartItem.setItem(item);
        CartItem saved = cartItemRepository.save(cartItem);
        return cartItemToDTO(saved);
    }

    @Override
    public void removeItemFromCart(Integer cartItemId) {
        CartItem item = cartItemRepository.findById(cartItemId)
                .orElseThrow(() -> new ResourceNotFoundException("CartItem", "cartItemId", cartItemId));
        cartItemRepository.delete(item);
    }

    @Override
    public CartItemDTO updateQuantity(Integer cartItemId, Integer quantity) {
        CartItem item = cartItemRepository.findById(cartItemId)
                .orElseThrow(() -> new ResourceNotFoundException("CartItem", "cartItemId", cartItemId));
        item.setQuantity(quantity);
        CartItem saved = cartItemRepository.save(item);
        return cartItemToDTO(saved);
    }

    @Override
    public List<CartItemDTO> getAllCartItems(Integer userId) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new ResourceNotFoundException("User", "userId", userId));
        Cart cart = cartRepository.findByActiveSessionAndUser(true, user);
        List<CartItem> cartItems = cart.getCartItems();
        return cartItems.stream()
                .map((cartItem) -> this.modelMapper.map(cartItem, CartItemDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    public int getCartItemCount(Integer userId) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new ResourceNotFoundException("User", "userId", userId));
        Cart cart = cartRepository.findByActiveSessionAndUser(true, user);
        return (int) cartItemRepository.countByCart(cart);
    }

    private CartItem dtoToCartItem(CartItemDTO cartItemDTO) {
        return modelMapper.map(cartItemDTO, CartItem.class);
    }

    private CartItemDTO cartItemToDTO(CartItem cartItem) {
        return modelMapper.map(cartItem, CartItemDTO.class);
    }
}

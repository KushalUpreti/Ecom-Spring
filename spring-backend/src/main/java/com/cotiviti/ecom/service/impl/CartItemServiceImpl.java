package com.cotiviti.ecom.service.impl;

import com.cotiviti.ecom.dto.CartItemDTO;
import com.cotiviti.ecom.exception.ResourceNotFoundException;
import com.cotiviti.ecom.model.Cart;
import com.cotiviti.ecom.model.CartItem;
import com.cotiviti.ecom.model.Item;
import com.cotiviti.ecom.model.User;
import com.cotiviti.ecom.projection.CartItemProjection;
import com.cotiviti.ecom.repository.CartItemRepository;
import com.cotiviti.ecom.repository.CartRepository;
import com.cotiviti.ecom.repository.ItemRepository;
import com.cotiviti.ecom.repository.UserRepository;
import com.cotiviti.ecom.service.CartItemService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

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
        CartItem searched = cart.getCartItems().stream()
                .filter(cartItem -> cartItem.getItem().getId() == itemId)
                .findAny()
                .orElse(null);
        if (searched != null) {
            searched.setQuantity(searched.getQuantity() + 1);
            CartItem saved = cartItemRepository.save(searched);
            return cartItemToDTO(saved);
        }
        CartItem cartItem = dtoToCartItem(cartItemDTO);
        cartItem.setCart(cart);
        cartItem.setItem(item);
        CartItem saved = cartItemRepository.save(cartItem);
        return cartItemToDTO(saved);
    }

    @Override
    public int removeItemFromCart(Integer cartItemId) {
        CartItem item = cartItemRepository.findById(cartItemId)
                .orElseThrow(() -> new ResourceNotFoundException("CartItem", "cartItemId", cartItemId));
        int itemCount = item.getQuantity();
        cartItemRepository.delete(item);
        return itemCount;
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
    public List<CartItemProjection> getAllCartItems(Integer userId) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new ResourceNotFoundException("User", "userId", userId));
        Cart cart = cartRepository.findByActiveSessionAndUser(true, user);
       List<CartItemProjection> list =  cartItemRepository.findByNamedParams(cart.getId());
        return list ;
    }

    @Override
    public int getCartItemCount(Integer userId) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new ResourceNotFoundException("User", "userId", userId));
        Cart cart = cartRepository.findByActiveSessionAndUser(true, user);
        List<CartItem> cartItems = cart.getCartItems();
        int sum = cartItems.stream().mapToInt(CartItem::getQuantity).sum();
        return sum;
    }

    private CartItem dtoToCartItem(CartItemDTO cartItemDTO) {
        return modelMapper.map(cartItemDTO, CartItem.class);
    }

    private CartItemDTO cartItemToDTO(CartItem cartItem) {
        return modelMapper.map(cartItem, CartItemDTO.class);
    }
}

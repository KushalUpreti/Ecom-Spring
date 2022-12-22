package com.cotiviti.ecom.service.impl;

import com.cotiviti.ecom.dto.UserDTO;
import com.cotiviti.ecom.model.Cart;
import com.cotiviti.ecom.model.Role;
import com.cotiviti.ecom.model.User;
import com.cotiviti.ecom.repository.CartRepository;
import com.cotiviti.ecom.repository.RoleRepository;
import com.cotiviti.ecom.repository.UserRepository;
import com.cotiviti.ecom.service.UserService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final CartRepository cartRepository;
    private final RoleRepository roleRepository;
    private final ModelMapper modelMapper;
    private final PasswordEncoder passwordEncoder;

    @Override
    public UserDTO saveUser(UserDTO userDTO) {
        String email = userDTO.getEmail();
        String username = email.substring(0, email.indexOf("@"));
        userDTO.setUsername(username);
        userDTO.setPassword(passwordEncoder.encode(userDTO.getPassword()));
        User user = this.dtoToUser(userDTO);

        Role roles = roleRepository.findByName("ADMIN").get();
        user.setRoles(Collections.singletonList(roles));

        User savedUser = userRepository.save(user);

        Cart cart = new Cart();
        cart.setUser(user);
        cart.setActiveSession(true);
        cartRepository.save(cart);

        return userToDTO(savedUser);
    }

    @Override
    public List<UserDTO> getAllUsers() {
        List<User> users = userRepository.findAll();
        return users.stream().map(this::userToDTO).collect(Collectors.toList());
    }

    @Override
    public User getUserByEmail(String email) {
       return userRepository.findByEmail(email);
    }

    private User dtoToUser(UserDTO userDTO) {
        return this.modelMapper.map(userDTO, User.class);
    }

    private UserDTO userToDTO(User user) {
        return this.modelMapper.map(user, UserDTO.class);
    }
}

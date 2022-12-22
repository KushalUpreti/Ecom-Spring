package com.cotiviti.ecom.controller;

import com.cotiviti.ecom.config.JwtUtils;
import com.cotiviti.ecom.dto.AuthDTO;
import com.cotiviti.ecom.dto.AuthRequestDTO;
import com.cotiviti.ecom.dto.UserDTO;
import com.cotiviti.ecom.model.User;
import com.cotiviti.ecom.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor

@RestController
@RequestMapping("/api/auth")
public class AuthController {
    private final AuthenticationManager authenticationManager;
    private final UserDetailsService userDetailsService;
    private final JwtUtils jwtUtils;
    private final UserService userService;

    @PostMapping("login")
    public ResponseEntity<AuthDTO> authenticate(@RequestBody AuthRequestDTO authRequest) {
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(authRequest.getEmail(), authRequest.getPassword()));
//        final UserDetails user = userDetailsService.loadUserByUsername(authRequest.getEmail());
        User user = userService.getUserByEmail(authRequest.getEmail());
        if (user != null) {
            String token = jwtUtils.generateToken(user.getEmail());
            String role = user.getRoles().get(0).getName();
            return new ResponseEntity<>(new AuthDTO(token, user.getEmail(), role, user.getId()), HttpStatus.OK);
        }
        return null;
    }

    @PostMapping("register")
    public ResponseEntity<UserDTO> addUser(@RequestBody UserDTO userDto) {
        UserDTO createUserDTO = userService.saveUser(userDto);
        return new ResponseEntity<>(createUserDTO, HttpStatus.CREATED);
    }
}

package com.cotiviti.ecom.controller;

import com.cotiviti.ecom.config.JwtUtils;
import com.cotiviti.ecom.dto.AuthDTO;
import com.cotiviti.ecom.dto.AuthRequestDTO;
import com.cotiviti.ecom.model.User;
import com.cotiviti.ecom.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class AuthController {
    private final AuthenticationManager authenticationManager;
    private final UserDetailsService userDetailsService;
    private final JwtUtils jwtUtils;
    private final UserService userService;

    @PostMapping("/auth/login")
    public ResponseEntity<AuthDTO> authenticate(@RequestBody AuthRequestDTO authRequest) {
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(authRequest.getEmail(), authRequest.getPassword()));
//        final UserDetails user = userDetailsService.loadUserByUsername(authRequest.getEmail());
        User user = userService.getUserByEmail(authRequest.getEmail());
        if (user != null) {
            String token = jwtUtils.generateToken(user.getEmail());
            return new ResponseEntity<>(new AuthDTO(token,user.getEmail(),user.getId()), HttpStatus.OK);
        }
        return null;
    }
}

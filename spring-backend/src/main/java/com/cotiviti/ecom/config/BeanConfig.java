package com.cotiviti.ecom.config;

import com.cotiviti.ecom.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@Configuration
public class BeanConfig {
    @Autowired
    UserService userService;

    @Bean
    public UserDetailsService userDetailsService() {
        return new UserDetailsService() {
            @Override
            public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
                com.cotiviti.ecom.model.User user = userService.getUserByEmail(email);
                return new User(user.getEmail(),user.getPassword(),Collections.singleton(new SimpleGrantedAuthority("ROLE_USER")));
            }
        };
    }
}

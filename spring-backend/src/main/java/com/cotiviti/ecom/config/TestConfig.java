package com.cotiviti.ecom.config;

import org.modelmapper.ModelMapper;
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
public class TestConfig {

    private final static List<UserDetails> APP_USERS = Arrays.asList(
            new User("kushal@email.com", "$2a$10$cgpYX//b24sBAJp2Q1/MYO1Kw5ngv4CmZ.rmyZBEppQFJHbX.btwe",
                    Collections.singleton(new SimpleGrantedAuthority("ROLE_ADMIN"))
            ));

    @Bean
    public UserDetailsService userDetailsService() {
        return email -> APP_USERS.stream().filter(userDetails -> userDetails.getUsername().equals(email))
                .findFirst().orElseThrow(() -> new UsernameNotFoundException("No user was found"));
    }

    @Bean
    public ModelMapper modelMapper(){
        return new ModelMapper ();
    }
}

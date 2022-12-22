package com.cotiviti.ecom.config;

import com.cotiviti.ecom.exception.ResourceNotFoundException;
import com.cotiviti.ecom.model.Role;
import com.cotiviti.ecom.repository.UserRepository;
import com.cotiviti.ecom.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Configuration
public class BeanConfig {
    @Autowired
    UserRepository userRepository;

    @Bean
    public UserDetailsService userDetailsService() {
        return new UserDetailsService() {
            @Override
            public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
                com.cotiviti.ecom.model.User user = userRepository.findByEmail(email);
                if(user == null){
                    throw new ResourceNotFoundException("User", "Email", 0);
                }
                return new User(user.getEmail(),user.getPassword(),mapRolesToAuthorities(user.getRoles()));
            }
        };
    }

    private Collection<GrantedAuthority> mapRolesToAuthorities(List<Role> roles) {
        return roles.stream().map(role -> new SimpleGrantedAuthority(role.getName())).collect(Collectors.toList());
    }


}

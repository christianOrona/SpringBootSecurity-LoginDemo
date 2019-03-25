package com.christianorona.SecurityDBDemo.service;

import com.christianorona.SecurityDBDemo.model.CustomUserDetails;
import com.christianorona.SecurityDBDemo.model.User;
import com.christianorona.SecurityDBDemo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
       Optional<User> optionalUser = userRepository.findByName(username.trim());
        optionalUser
                .orElseThrow(() -> new UsernameNotFoundException("User name not found"));
       return optionalUser
               .map(user1 -> new CustomUserDetails(user1)).get();
    }
}

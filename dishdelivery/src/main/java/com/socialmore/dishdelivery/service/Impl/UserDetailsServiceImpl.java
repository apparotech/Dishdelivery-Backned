package com.socialmore.dishdelivery.service.Impl;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.socialmore.dishdelivery.exception.ResourceNotFoundException;
import com.socialmore.dishdelivery.repository.CustomerRepo;
import com.socialmore.dishdelivery.repository.UserRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class UserDetailsServiceImpl implements  UserDetailsService  {

    //private CustomerRepo customerRepo;
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws  UsernameNotFoundException {
        return this.userRepository.findByUsername(username).orElseThrow(() -> new ResourceNotFoundException("User", "userName", username));

      // return this.userRepository.findByEmail(email).orElseThrow(() -> new ResourceNotFoundException("User", "userName", email));
    
}
    
}

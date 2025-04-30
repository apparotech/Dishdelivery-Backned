package com.socialmore.dishdelivery.controller;

import org.apache.catalina.UserDatabase;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.socialmore.dishdelivery.entity.Customer;
import com.socialmore.dishdelivery.entity.User;
import com.socialmore.dishdelivery.enuk.Role;
import com.socialmore.dishdelivery.exception.ApiException;
import com.socialmore.dishdelivery.exception.EmailAlreadyExistsException;
import com.socialmore.dishdelivery.payloads.Customerdto;
import com.socialmore.dishdelivery.payloads.JwtAuthResponse;
import com.socialmore.dishdelivery.payloads.LoginRequest;
import com.socialmore.dishdelivery.payloads.userdto;
import com.socialmore.dishdelivery.repository.UserRepository;
import com.socialmore.dishdelivery.security.JwtTokenHelper;
import com.socialmore.dishdelivery.service.CustomerService;

import jakarta.persistence.PostRemove;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/customer-auth")
@AllArgsConstructor
public class CustomerController {

    @Autowired
    private CustomerService customerService;
    @Autowired
    private UserRepository userRepository;
      private final AuthenticationManager authenticationManager;

      private final JwtTokenHelper jwtTokenHelper;

      private  ModelMapper modelMapper;

    @Autowired
     private final UserDetailsService userDetailsService;

    @PostMapping("/addCustomer")
    public ResponseEntity<Customerdto> addCustomer(@RequestBody Customerdto     customerdto) {
        Customerdto createdCustomer = customerService.addCustomer(customerdto);
        return new ResponseEntity<>(createdCustomer, HttpStatus.CREATED);
    }

/*
      @PostMapping("/register")
    public ResponseEntity<JwtAuthResponse> registerUser(@Valid @RequestBody Customerdto customerdto) {
        Customerdto customer1;
        User user = null;

        try {
            customer1 = customerService.addCustomer(customerdto);
        } catch( EmailAlreadyExistsException e) {
            throw new ApiException(e.getMessage());
        }

         UserDetails userDetails = this.userDetailsService.loadUserByUsername(user.getEmail());
        JwtAuthResponse jwtAuthResponse = new JwtAuthResponse(this.jwtTokenHelper.generateToken(userDetails), customer1);
        return ResponseEntity.ok(jwtAuthResponse);
    }
     */

     @PostMapping("/login")
     public ResponseEntity<JwtAuthResponse> authenticateUser (@Valid @RequestBody LoginRequest loginRequest ) {
        try {
            System.out.println(loginRequest.getUsername() + loginRequest.getPassword());
            this.authenticate(loginRequest.getUsername(), loginRequest.getPassword());
        } catch(Exception e) {
             throw new BadCredentialsException(e.getMessage());
        }

        UserDetails userDetails = this.userDetailsService.loadUserByUsername(loginRequest.getUsername());
        User user =  this.userRepository.findByUsername(userDetails.getUsername()).orElseThrow();
        JwtAuthResponse jwtAuthResponse =  new JwtAuthResponse(this.jwtTokenHelper.generateToken(userDetails, Role.CUSTOMER), this.modelMapper.map(user, userdto.class));
        return ResponseEntity.ok(jwtAuthResponse);
     }


      private void authenticate(String username, String password) throws Exception {
        UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(username, password);
        try {
            this.authenticationManager.authenticate(authenticationToken);
        } catch (BadCredentialsException e) {
            System.out.println("Invalid Details !!");
            throw new ApiException("Invalid username or password !!");
        }
    }

    @PostMapping("/logout")
    public ResponseEntity<String>  logoutUser(@RequestHeader("Authorization") String authHeader)  {
        if(authHeader == null || !authHeader.startsWith("Bearer")) {
            return new ResponseEntity<>("Invalid token", HttpStatus.BAD_REQUEST);
        }

        String token = authHeader.substring(7);

        // Invalidate the token
        tokenService.invalidateToken(token);

        return new ResponseEntity<>("User logged out successfully", HttpStatus.OK);
    }
}

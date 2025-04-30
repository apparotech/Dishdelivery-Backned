package com.socialmore.dishdelivery.controller;

import org.modelmapper.ModelMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.socialmore.dishdelivery.entity.Customer;
import com.socialmore.dishdelivery.entity.User;
import com.socialmore.dishdelivery.exception.ApiException;
import com.socialmore.dishdelivery.exception.EmailAlreadyExistsException;
import com.socialmore.dishdelivery.payloads.Customerdto;
import com.socialmore.dishdelivery.payloads.JwtAuthResponse;
import com.socialmore.dishdelivery.payloads.LoginRequest;
import com.socialmore.dishdelivery.repository.CustomerRepo;
import com.socialmore.dishdelivery.security.JwtTokenHelper;
import com.socialmore.dishdelivery.service.CustomerService;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/raj")
@AllArgsConstructor
public class AuthController {

    /*
    private final CustomerService customerService;
    private final JwtTokenHelper jwtTokenHelper;
    private final AuthenticationManager authenticationManager;
    private UserDetailsService userDetailsService;
    private CustomerRepo customerRepo;
    private ModelMapper modelMapper;


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
       // JwtAuthResponse jwtAuthResponse = new JwtAuthResponse(this.jwtTokenHelper.generateToken(userDetails), customer1);
        return ResponseEntity.ok(jwtAuthResponse);
    }
/* 
    @PostMapping("/login")
    public ResponseEntity<JwtAuthResponse> authenticateUser(@Valid @RequestBody LoginRequest loginRequest) {
        try {
             System.out.println(loginRequest.getEmail()+ loginRequest.getPassword());
             this.authenticate(loginRequest.getEmail(),  loginRequest.getPassword());
        }  catch(Exception e) {
            throw new BadCredentialsException(e.getMessage());
        }

        UserDetails userDetails = this.userDetailsService.loadUserByUsername(loginRequest.getEmail());
       // Customer customer = this.customerRepo.findByEmail(userDetails.getUsername())orElseThrow();
      // Customer customer = this.customerRepo.findByEmail(userDetails.getUsername())
       //.orElseThrow(() -> new RuntimeException("Customer not found with email: " + userDetails.getUsername()));
       // JwtAuthResponse jwtAuthResponse =  new JwtAuthResponse(this.jwtTokenHelper.generateToken(userDetails), this.modelMapper.map(customer, Customerdto.class));
        return ResponseEntity.ok(jwtAuthResponse);
    }

    private void authenticate(String email, String password)  throws  Exception {
        UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(email, password);
        try {
            this.authenticationManager.authenticate(authenticationToken);
            
        }  catch(BadCredentialsException e) {
            System.out.println("invalid Details!!");
            throw new ApiException("Invalid username or password !!");
        }
    }
    */
}

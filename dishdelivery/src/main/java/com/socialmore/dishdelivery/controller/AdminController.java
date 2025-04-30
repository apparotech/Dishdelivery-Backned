package com.socialmore.dishdelivery.controller;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.security.authentication.AuthenticationManager;

import com.socialmore.dishdelivery.entity.User;
import com.socialmore.dishdelivery.enuk.Role;
import com.socialmore.dishdelivery.payloads.JwtAuthResponse;
import com.socialmore.dishdelivery.payloads.LoginRequest;
import com.socialmore.dishdelivery.payloads.admindto;
import com.socialmore.dishdelivery.repository.UserRepository;
import com.socialmore.dishdelivery.security.JwtTokenHelper;
import com.socialmore.dishdelivery.service.AdminService;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;

import com.socialmore.dishdelivery.exception.ApiException;
import com.socialmore.dishdelivery.payloads.userdto;

import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
@Slf4j
@RestController
@RequestMapping("/admin-auth")
public class AdminController {

  private final AdminService adminService;

    private final AuthenticationManager authenticationManager;
    private final JwtTokenHelper jwtTokenHelper;
    private final ModelMapper modelMapper;
    private final UserRepository userRepository;
    private final UserDetailsService userDetailsService;

    @Autowired
    public AdminController(
        AdminService adminService,
        AuthenticationManager authenticationManager,
        JwtTokenHelper jwtTokenHelper,
        ModelMapper modelMapper,
        UserRepository userRepository,
        UserDetailsService userDetailsService
    ) {
        this.adminService = adminService;
        this.authenticationManager = authenticationManager;
        this.jwtTokenHelper = jwtTokenHelper;
        this.modelMapper = modelMapper;
        this.userRepository = userRepository;
        this.userDetailsService = userDetailsService;
    }

  


      @PostMapping("/addAdmin")
       public  ResponseEntity<admindto> addAdmin(@RequestBody admindto admindto) {
        log.info("Adding AADMIN: {}", admindto.getUsername());
        admindto createdAdmin = adminService.addAdmin(admindto);
        return new ResponseEntity<>(createdAdmin, HttpStatus.CREATED);


    }

   




     @PostMapping("/admin-login")
     public ResponseEntity<JwtAuthResponse> authenticateUser (@Valid @RequestBody LoginRequest loginRequest ) {
        try {
            System.out.println(loginRequest.getUsername() + loginRequest.getPassword());
            this.authenticate(loginRequest.getUsername(), loginRequest.getPassword());
        } catch(Exception e) {
             throw new BadCredentialsException(e.getMessage());
        }

        UserDetails userDetails = this.userDetailsService.loadUserByUsername(loginRequest.getUsername());
        User user =  this.userRepository.findByUsername(userDetails.getUsername()).orElseThrow();
        JwtAuthResponse jwtAuthResponse =  new JwtAuthResponse(this.jwtTokenHelper.generateToken(userDetails, Role.ADMIN), this.modelMapper.map(user, userdto.class));
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
 
 
    
}

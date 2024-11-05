package com.socialmore.dishdelivery.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.socialmore.dishdelivery.entity.Customer;
import com.socialmore.dishdelivery.payloads.Customerdto;
import com.socialmore.dishdelivery.service.CustomerService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/customers")

public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @PostMapping("/addCustomer") 
    public ResponseEntity<Customer>addCustomer(@Valid @RequestBody Customerdto customerdto) {
        Customer newCustomer = customerService.addCustomer(customerdto);
         return new ResponseEntity<>(newCustomer, HttpStatus.CREATED);
    }


    
}

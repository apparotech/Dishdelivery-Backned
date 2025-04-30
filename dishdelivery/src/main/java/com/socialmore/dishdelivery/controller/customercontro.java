package com.socialmore.dishdelivery.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.socialmore.dishdelivery.entity.User;
import com.socialmore.dishdelivery.payloads.Customerdto;
import com.socialmore.dishdelivery.service.CustomerService;

@RestController
@RequestMapping("/api/customers")
public class customercontro {

    private final CustomerService customerService;

     public customercontro(CustomerService customerService) {
        this.customerService = customerService;
    }

       @PutMapping("/{customerId}")
    public ResponseEntity<Customerdto> editCustomerDetails(
            @PathVariable Integer customerId,
            @RequestBody Customerdto updatedCustomerDto, @AuthenticationPrincipal User user) {
        Customerdto updatedCustomer = customerService.editCustomerDetails(customerId, updatedCustomerDto);
        return ResponseEntity.ok(updatedCustomer);
    }
    
}

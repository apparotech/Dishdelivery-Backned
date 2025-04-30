package com.socialmore.dishdelivery.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/delivery")
public class DeliveryPersonController {

    @GetMapping("/orders")
    public String getDeliveryOrders() {
        return "Welcome to Delivery Person Orders";
    }
    
}

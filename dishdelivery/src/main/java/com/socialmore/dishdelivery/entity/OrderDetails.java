package com.socialmore.dishdelivery.entity;

import java.time.LocalDate;

import jakarta.persistence.CascadeType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;

public class OrderDetails {
    
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Integer orderId;

    private LocalDate orderDate = LocalDate.now();

   @OneToOne(cascade= CascadeType.ALL)
    private FoodCart cart;

    private String  orderStatus;
}

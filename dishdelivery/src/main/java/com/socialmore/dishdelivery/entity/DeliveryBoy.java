package com.socialmore.dishdelivery.entity;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.Data;

@Entity
@Data
@DiscriminatorValue("DELIVERY_BOY")
public class DeliveryBoy extends  User{
    
    private String vehicleNumber;
    private boolean available;
}

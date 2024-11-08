package com.socialmore.dishdelivery.entity;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Service
public class FoodCart {
    
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private String cartId;

    @OneToOne(cascade = CascadeType.ALL)
    private Customer customer;


    @OneToMany(cascade = CascadeType.ALL)
    private List<Item>  items = new ArrayList<>();	

}

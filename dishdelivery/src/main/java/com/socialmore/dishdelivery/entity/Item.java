package com.socialmore.dishdelivery.entity;

import org.springframework.stereotype.Service;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@NoArgsConstructor
@Data
@ToString
@EqualsAndHashCode

@Service
public class Item {
    
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Integer itemId;

    @NotNull(message= "Please Enter Item Name...")
    @Size(min =3 , max =20)
    private  String itemName;

  
   @OneToOne(cascade= CascadeType.ALL)
    private Category category;

    @NotNull(message =  "Please Enter quantity..")
    @Min(1)
    private Integer quantity;

    @DecimalMin("1.00")
    private Double cost;


}

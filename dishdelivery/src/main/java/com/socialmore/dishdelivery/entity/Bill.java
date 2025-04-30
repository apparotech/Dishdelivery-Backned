package com.socialmore.dishdelivery.entity;

import java.time.LocalDateTime;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
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
public class Bill {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Integer billId;
    private LocalDateTime billDate;
	
	//@OneToOne(cascade =  CascadeType.ALL)
    //@OneToOne(cascade = CasecadeType.ALL)
    //@OneToOne(cascade =  CascadeType.ALL)
   // @OneToOne(cascade = CasecadeType.ALL)
   @OneToOne(cascade = CascadeType.ALL)
	private OrderDetails order;
	
	private Integer totalItem;
	
	private Double totalCost;

}

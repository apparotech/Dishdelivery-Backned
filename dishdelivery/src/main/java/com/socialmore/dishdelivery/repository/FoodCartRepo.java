package com.socialmore.dishdelivery.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.socialmore.dishdelivery.entity.FoodCart;

@Repository
public interface  FoodCartRepo  extends  JpaRepository<FoodCart, String>{
    
}

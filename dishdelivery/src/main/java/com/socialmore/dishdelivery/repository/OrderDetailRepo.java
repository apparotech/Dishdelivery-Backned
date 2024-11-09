package com.socialmore.dishdelivery.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.socialmore.dishdelivery.entity.FoodCart;
import com.socialmore.dishdelivery.entity.OrderDetails;

@Repository
public interface  OrderDetailRepo  extends  JpaRepository<OrderDetails, Integer>{

    public List<OrderDetails> findByCart(FoodCart cart);
    
}

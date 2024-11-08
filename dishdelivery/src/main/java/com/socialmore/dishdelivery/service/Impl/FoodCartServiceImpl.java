package com.socialmore.dishdelivery.service.Impl;

import org.springframework.beans.factory.annotation.Autowired;

import com.socialmore.dishdelivery.entity.FoodCart;
import com.socialmore.dishdelivery.entity.Item;
import com.socialmore.dishdelivery.exception.FoodCartException;
import com.socialmore.dishdelivery.repository.FoodCartRepo;
import com.socialmore.dishdelivery.service.FoodCartService;

public class FoodCartServiceImpl implements  FoodCartService {

    @Autowired
    private FoodCartRepo  foodCartRepo;


    public FoodCart addItemToCart(FoodCart foodCart, Item item) throws FoodCartException {

        if(foodCart.getItems().contains(item)) throw new FoodCartException("This Item is already in cart (if want then increse quantity)....");
		
		foodCart.getItems().add(item);
		
		FoodCart updatedCart = foodCartRepo.save(foodCart);
		
		return updatedCart;
    }

    
}

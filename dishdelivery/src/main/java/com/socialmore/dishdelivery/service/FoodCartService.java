package com.socialmore.dishdelivery.service;

import com.socialmore.dishdelivery.entity.FoodCart;
import com.socialmore.dishdelivery.entity.Item;
import com.socialmore.dishdelivery.exception.FoodCartException;

public interface  FoodCartService {

    public FoodCart addItemToCart(FoodCart foodCart, Item item) throws FoodCartException;
    //public FoodCart  ()
    
}

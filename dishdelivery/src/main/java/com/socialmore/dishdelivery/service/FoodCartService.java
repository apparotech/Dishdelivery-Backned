package com.socialmore.dishdelivery.service;

import com.socialmore.dishdelivery.entity.FoodCart;
import com.socialmore.dishdelivery.entity.Item;
import com.socialmore.dishdelivery.exception.FoodCartException;

public interface  FoodCartService {

    public FoodCart addItemToCart(FoodCart foodCart, Item item) throws FoodCartException;
    //public FoodCart  ()

    public FoodCart increaseQuantityOfItem(FoodCart foodCart, Item item , Integer quantity ) throws  FoodCartException;

    public FoodCart reduceQuantityOfItem(FoodCart foodCart, Item item, Integer quantity) throws FoodCartException;
    public FoodCart removeItemFromCart(FoodCart foodCart, Item item) throws FoodCartException;
	
	public FoodCart clearCart(FoodCart foodCart) throws FoodCartException;

    
    
}

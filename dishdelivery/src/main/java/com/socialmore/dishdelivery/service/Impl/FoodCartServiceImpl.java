package com.socialmore.dishdelivery.service.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.socialmore.dishdelivery.entity.FoodCart;
import com.socialmore.dishdelivery.entity.Item;
import com.socialmore.dishdelivery.exception.FoodCartException;
import com.socialmore.dishdelivery.repository.FoodCartRepo;
import com.socialmore.dishdelivery.service.FoodCartService;

@Service
public class FoodCartServiceImpl implements  FoodCartService {

    @Autowired
    private FoodCartRepo  foodCartRepo;


    public FoodCart addItemToCart(FoodCart foodCart, Item item) throws FoodCartException {

        if(foodCart.getItems().contains(item)) throw new FoodCartException("This Item is already in cart (if want then increse quantity)....");
		
		foodCart.getItems().add(item);
		
		FoodCart updatedCart = foodCartRepo.save(foodCart);
		
		return updatedCart;
    }


    public FoodCart increaseQuantityOfItem (FoodCart foodCart, Item item, Integer quantity) throws FoodCartException  {

      if(foodCart.getItems().contains(item)) {

           for(Item listItem : foodCart.getItems() ) {
            if(listItem.equals(item)) {
              listItem.setQuantity(listItem.getQuantity()+quantity);
					
					break;
            }
           }

           FoodCart updateCart = foodCartRepo.save(foodCart);
           return updateCart;
      }
       else {
        throw new FoodCartException("No such Item in cart, please add it first.....");
       }
    }

    @Override
    public FoodCart reduceQuantityOfItem(FoodCart foodCart, Item item, Integer quantity) throws FoodCartException {
      
      if(foodCart.getItems().contains(item)) {
        
        for(Item listItem : foodCart.getItems()) {
          
          if(listItem.equals(item)) {
            
            if(listItem.getQuantity()<quantity) {
              throw new FoodCartException("Not enough quantity to remove.....");
            }
            
            listItem.setQuantity(listItem.getQuantity()-quantity);
            
            // if item quantity = 0 , then remove it 
            
            if(listItem.getQuantity()==0) {
              foodCart.getItems().remove(listItem);
            }
            
            if(foodCart.getItems().size()==0) {
              foodCartRepo.delete(foodCart);
              
              System.out.println("FoodCart Deleted.....");
              
            }
            
            break;
          }
          
        }
        
        FoodCart updatedCart = foodCartRepo.save(foodCart);
        
        return updatedCart;
      }
      else {
        throw new FoodCartException("No such Item in cart, please add it first.....");
      }
      
    }
  
    
    @Override
    public FoodCart removeItemFromCart(FoodCart foodCart, Item item) throws FoodCartException {
      
      if(foodCart.getItems().contains(item)) {
        
        foodCart.getItems().remove(item);
  
        FoodCart updatedCart = foodCartRepo.save(foodCart);
        
        return updatedCart;
        
      }
      else {
        throw new FoodCartException("No such item exist in Cart......");
      }
      
    }
  
    
    @Override
    public FoodCart clearCart(FoodCart foodCart) throws FoodCartException {
  
      if(foodCart.getItems().isEmpty()) throw new FoodCartException("Cart is already Empty....");
      
      foodCart.getItems().clear();
      
      FoodCart emptyCart = foodCartRepo.save(foodCart);
      
      return emptyCart;
    }

    
}

package com.socialmore.dishdelivery.controller;
import com.socialmore.dishdelivery.entity.Item;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.socialmore.dishdelivery.entity.FoodCart;
import com.socialmore.dishdelivery.service.FoodCartService;

import jakarta.validation.Valid;

@RestController("/cart")
public class CartController {

    @Autowired
    private FoodCartService foodCartService;

    @PostMapping("/addItemToCart")
    public ResponseEntity<FoodCart> addItemToCartHandler(@RequestBody FoodCart foodCart, @RequestBody  Item item) {

        FoodCart updatedCart = foodCartService.addItemToCart(foodCart, item);
        return new  ResponseEntity<FoodCart>(updatedCart, HttpStatus.ACCEPTED);

    }


    @PutMapping("/increaseItemQuantity/{quantity}")
    public ResponseEntity<FoodCart> increaseQuantityOfItemHandler(@Valid @RequestBody FoodCart foodCart,@Valid @RequestBody Item item,@PathVariable("quantity") Integer quantity) {

        FoodCart updateCart = foodCartService.increaseQuantityOfItem(foodCart, item, quantity);

        return  new  ResponseEntity<FoodCart>(updateCart, HttpStatus.ACCEPTED);
    }


    @PutMapping("/reduceItemQuantity/{quantity}")
	public ResponseEntity<FoodCart> reduceQuantityOfItemHandler(@Valid @RequestBody FoodCart foodCart,@Valid @RequestBody Item item,@PathVariable("quantity") Integer quantity){
		
		FoodCart updateCart = foodCartService.reduceQuantityOfItem(foodCart, item, quantity);
		
		return new ResponseEntity<FoodCart>(updateCart, HttpStatus.ACCEPTED);
		
	}
	
	
	
	@DeleteMapping("/removeItem")
	public ResponseEntity<FoodCart> removeItemFromCartHandler(@Valid @RequestBody FoodCart foodCart,@Valid @RequestBody Item item){
		
		FoodCart updateCart = foodCartService.removeItemFromCart(foodCart, item);
		
		return new ResponseEntity<FoodCart>(updateCart, HttpStatus.ACCEPTED);
		
	}




	@PutMapping(value = "/clearCart")
	public ResponseEntity<FoodCart> cleartCartHandler(@Valid @RequestBody FoodCart foodCart){
		
		FoodCart emptyCart = foodCartService.clearCart(foodCart);
		
		return new ResponseEntity<FoodCart>(emptyCart, HttpStatus.ACCEPTED);
		
	}

   
    
}



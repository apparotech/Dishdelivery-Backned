package com.socialmore.dishdelivery.exception;

public class ItemNotFoundException  extends  RuntimeException{

    public ItemNotFoundException() {

    }

    public ItemNotFoundException(String message) {
        super(message);
    }
    
}

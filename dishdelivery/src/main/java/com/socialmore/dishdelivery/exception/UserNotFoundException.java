package com.socialmore.dishdelivery.exception;

public class UserNotFoundException  extends  RuntimeException{
    public UserNotFoundException(String message) {
        super(message);
    }
}

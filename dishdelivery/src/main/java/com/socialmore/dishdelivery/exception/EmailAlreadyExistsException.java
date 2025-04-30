package com.socialmore.dishdelivery.exception;

public class EmailAlreadyExistsException  extends  RuntimeException {

     public EmailAlreadyExistsException(String message) {
        super(message);
    }
}

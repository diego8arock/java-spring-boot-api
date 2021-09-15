package com.mercadolibre.api.errors;

public class UserExistsException extends RuntimeException {
     public UserExistsException(String email){
        super(String.format("User with email %s already exists", email));
    }
}

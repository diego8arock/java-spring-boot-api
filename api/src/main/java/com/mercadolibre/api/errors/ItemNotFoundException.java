package com.mercadolibre.api.errors;

public class ItemNotFoundException extends RuntimeException {
    public ItemNotFoundException(String id){
        super(String.format("Item with id %s was not found", id));
    }    
}

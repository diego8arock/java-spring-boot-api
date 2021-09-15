package com.mercadolibre.api.errors;

public class ItemExistsException extends RuntimeException{
    public ItemExistsException(String id){
        super(String.format("Item with id %s already exists", id));
    }
}

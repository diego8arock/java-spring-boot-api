package com.mercadolibre.api.controllers.handlers;

import com.mercadolibre.api.errors.ItemExistsException;
import com.mercadolibre.api.errors.ItemNotFoundException;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.http.HttpStatus;

@ControllerAdvice
public class ItemControllerAdvice {

    @ResponseBody
    @ExceptionHandler(ItemNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    String itemNotFoundHandler(ItemNotFoundException ex) {
        return ex.getMessage();
    }

    @ResponseBody
    @ExceptionHandler(ItemExistsException.class)
    @ResponseStatus(HttpStatus.CONFLICT)
    String itemExistsHandler(ItemExistsException ex) {
        return ex.getMessage();
    }
    
}

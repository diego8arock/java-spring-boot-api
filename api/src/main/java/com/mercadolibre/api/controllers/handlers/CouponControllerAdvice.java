package com.mercadolibre.api.controllers.handlers;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.mercadolibre.api.errors.CouponNotFoundException;

import org.springframework.http.HttpStatus;

@ControllerAdvice
public class CouponControllerAdvice {

    @ResponseBody
    @ExceptionHandler(CouponNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    String couponNotFoundHandler(CouponNotFoundException ex) {
        return ex.getMessage();
    }
    
}

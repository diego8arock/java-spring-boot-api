package com.mercadolibre.api.errors;

public class CouponNotFoundException extends RuntimeException {
    public CouponNotFoundException(Long id){
        super(String.format("Coupon with id %s was not found", id));
    }
}

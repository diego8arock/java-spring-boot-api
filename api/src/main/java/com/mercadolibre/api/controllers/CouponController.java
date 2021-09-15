package com.mercadolibre.api.controllers;

import java.util.List;

import javax.validation.Valid;

import com.mercadolibre.api.dtos.CouponDTO;
import com.mercadolibre.api.models.FavoritesCount;
import com.mercadolibre.api.models.ItemsCoupon;
import com.mercadolibre.api.services.CouponServices;
import com.mercadolibre.api.services.UserItemServices;
import com.mercadolibre.api.services.UserServices;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CouponController {
    
    @Autowired
    CouponServices services;
    @Autowired
    UserServices userServices;
    @Autowired
    UserItemServices userItemServices;

    @PostMapping("/coupon/add")
    ResponseEntity<String> newCoupon(@RequestBody @Valid CouponDTO newCupon){
        services.newCoupon(newCupon);
        return ResponseEntity.ok("Coupon was added"); 
    }

    @GetMapping("/coupon/stats")
    List<FavoritesCount> getItemsStats(){
        return userItemServices.getFavoritesStats();
    }

    @GetMapping("/coupon/{id}")
    CouponDTO getCoupon(@PathVariable Long id){
        return services.getCoupon(id); 
    }

    @GetMapping("/coupon")
    List<CouponDTO> getCoupons(){
        return services.getCoupons(); 
    }

    @PostMapping("/coupon")
    ItemsCoupon validateCoupon(@RequestBody @Valid ItemsCoupon itemsCoupon){
        return services.validateCoupon(itemsCoupon); 
    }

    @DeleteMapping("/coupon/{id}")
    ResponseEntity<String> deleteCoupon(@PathVariable Long id){
        services.deleteCoupon(id);
        return ResponseEntity.ok(String.format("Coupon with id %s was deleted", id)); 
    }

}

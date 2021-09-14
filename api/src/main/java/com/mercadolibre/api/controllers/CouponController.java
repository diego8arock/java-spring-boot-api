package com.mercadolibre.api.controllers;

import java.util.List;

import com.mercadolibre.api.dtos.CouponDTO;
import com.mercadolibre.api.models.FavoritesCount;
import com.mercadolibre.api.models.ItemsCoupon;
import com.mercadolibre.api.services.CouponServices;
import com.mercadolibre.api.services.UserItemServices;
import com.mercadolibre.api.services.UserServices;

import org.springframework.beans.factory.annotation.Autowired;
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
    CouponDTO newUser(@RequestBody CouponDTO newUser){
        return services.newCoupon(newUser);
    }

    @GetMapping("/coupon/stats")
    List<FavoritesCount> getItemsStats(){
        return userItemServices.getFavoritesStats();
    }

    @GetMapping("/coupon")
    List<CouponDTO> getCoupons(){
        return services.getCoupons(); 
    }

    @PostMapping("/coupon")
    ItemsCoupon validateCoupon(@RequestBody ItemsCoupon itemsCoupon){
        return services.validateCoupon(itemsCoupon); 
    }

    @DeleteMapping("/coupon/{id}")
    void deleteCoupon(@PathVariable Long id){
        services.deleteCoupon(id);
    }

}

package com.mercadolibre.api.database;

import com.mercadolibre.api.dtos.CouponDTO;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CouponRepository extends JpaRepository<CouponDTO, Long>  {
    
}

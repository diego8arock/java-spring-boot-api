package com.mercadolibre.api.dtos;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "coupons")
public class CouponDTO {
    
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "coupon_seq") 
    private Long id;
    
    @Column(precision=10, scale=2, nullable = false)
    private Double value;

    public CouponDTO() {}

    public CouponDTO(Double value) {
        this.setValue(value);
    }
    public Double getValue() {
        return value;
    }
    public void setValue(Double value) {
        this.value = value;
    }
}

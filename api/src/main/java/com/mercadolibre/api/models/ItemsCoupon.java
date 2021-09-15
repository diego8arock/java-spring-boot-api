package com.mercadolibre.api.models;

import java.util.ArrayList;
import java.util.List;

import javax.validation.constraints.NotBlank;

public class ItemsCoupon {

    @NotBlank(message = "Items Ids is mandatory")
    private List<String> item_ids;
    
    @NotBlank(message = "Amount is mandatory")
    private Double amount;

    public ItemsCoupon(){
        this.item_ids = new ArrayList<String>();
    }
    
    public ItemsCoupon(List<String> item_ids, Double amount) {
        this.item_ids = item_ids;
        this.amount = amount;
    }

    public void addItemID(String id){
        this.item_ids.add(id);
    }

    public List<String> getItem_ids() {
        return item_ids;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public void setItem_ids(List<String> item_ids) {
        this.item_ids = item_ids;
    }
    
}

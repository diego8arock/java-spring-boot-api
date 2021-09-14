package com.mercadolibre.api.dtos;

import java.io.Serializable;

public class UserItemDTOCompositeKey  implements Serializable{
    
    private Long user;
    private String item;
    
    public Long getUser() {
        return user;
    }
    public String getItem() {
        return item;
    }
    public void setItem(String item) {
        this.item = item;
    }
    public void setUser(Long user) {
        this.user = user;
    }
}

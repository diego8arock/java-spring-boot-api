package com.mercadolibre.api.models;

import javax.validation.constraints.NotBlank;

public class UserItem {
    
    @NotBlank(message = "Item Id is mandatory")
    private String itemId;

    @NotBlank(message = "User Id is mandatory")
    private Long userId;

    public UserItem() { }

    public UserItem(String itemId, Long userId) {
        this.itemId = itemId;
        this.userId = userId;
    }

    public String getItemId() {
        return itemId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public void setItemId(String itemId) {
        this.itemId = itemId;
    }

}

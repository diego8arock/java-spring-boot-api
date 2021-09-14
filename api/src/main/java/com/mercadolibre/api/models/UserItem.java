package com.mercadolibre.api.models;

public class UserItem {
    
    private String itemId;

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

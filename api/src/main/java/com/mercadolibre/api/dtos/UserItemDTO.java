package com.mercadolibre.api.dtos;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity(name = "users_items")
@Table(name = "users_items", uniqueConstraints = {@UniqueConstraint(columnNames = {"items_id","users_id"})})
@IdClass(UserItemDTOCompositeKey.class)
public class UserItemDTO {
    
    @Id
    @ManyToOne
    @JoinColumn(name = "users_id", nullable = false)
    private UserDTO user;

    @Id
    @ManyToOne
    @JoinColumn(name = "items_id", nullable = false)
    private ItemDTO item;

    public UserItemDTO() { }

    public UserItemDTO(UserDTO user) {
        this.user = user;
    }

    public UserItemDTO(UserDTO user, ItemDTO item) {
        this.user = user;
        this.item = item;
    }

    @Override
    public String toString(){
        return user.toString() + " - " + item.toString();
    }

}

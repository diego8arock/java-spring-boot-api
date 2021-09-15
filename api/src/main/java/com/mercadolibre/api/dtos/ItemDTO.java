package com.mercadolibre.api.dtos;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name = "items")
public class  ItemDTO {
    
    private @Id String id;

    @Column(precision=10, scale=2, nullable = false)
    @NotBlank(message = "Price is mandatory")
    private Double price;

    @OneToMany(mappedBy = "item")
    private Set<UserItemDTO> favorites;

    public ItemDTO() { }

    //constructor only as workaround for SB-JPA bug using @OneToMany https://github.com/spring-projects/spring-data-jpa/issues/1710
    public ItemDTO(String id) {
        this.id = id;
     }

    public ItemDTO(String id, Double price) {
        this.id = id;
        this.price = price;
    }

    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Double getPrice() {
        return price;
    }
    public void setPrice(Double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return String.format("Item { id=%s, price=%s }",this.id, this.price);       
    }
}

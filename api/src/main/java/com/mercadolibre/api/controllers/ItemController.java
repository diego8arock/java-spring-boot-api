package com.mercadolibre.api.controllers;

import java.util.List;

import com.mercadolibre.api.dtos.ItemDTO;
import com.mercadolibre.api.services.ItemServices;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ItemController {

    @Autowired
    ItemServices services;

    @PostMapping("/item")
    ItemDTO newItem(@RequestBody ItemDTO newItem){        
        return services.newItem(new ItemDTO(newItem.getId(), newItem.getPrice()));
    }

    @PostMapping("/items")
    void newItems(@RequestBody List<ItemDTO> newItem){        
        services.newItems(newItem);
    }

    @GetMapping("/item")
    List<ItemDTO> getItems(){
        return services.getItems();
    }

    @DeleteMapping("/item/{id}")
    void deleteItem(@PathVariable String id){
        services.deleteItem(id);
    }

}

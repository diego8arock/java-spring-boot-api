package com.mercadolibre.api.controllers;

import java.util.List;

import javax.validation.Valid;

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

    @PostMapping("/items")
    ItemDTO newItem(@RequestBody @Valid ItemDTO newItem){        
        return services.newItem(newItem);
    }

    @PostMapping("/items/list")
    void newItems(@RequestBody @Valid List<ItemDTO> newItem){        
        services.newItems(newItem);
    }

    @GetMapping("/items")
    List<ItemDTO> getItems(){
        return services.getItems();
    }
    
    @GetMapping("/items/{id}")
    ItemDTO getItem(@PathVariable String id){
        return services.getItem(id);
    }

    @DeleteMapping("/items/{id}")
    void deleteItem(@PathVariable String id){
        services.deleteItem(id);
    }

}

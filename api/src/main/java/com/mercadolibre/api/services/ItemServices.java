package com.mercadolibre.api.services;

import java.util.List;
import java.util.function.Consumer;

import com.mercadolibre.api.database.ItemRepository;
import com.mercadolibre.api.dtos.ItemDTO;
import com.mercadolibre.api.errors.ItemNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;

@Service
public class ItemServices {

    @Autowired
    private ItemRepository repo; 

    //private static final Logger log = LoggerFactory.getLogger(ItemServices.class);

    public ItemDTO newItem(ItemDTO newItem){
        return repo.save(newItem);
    }

    public void newItems(List<ItemDTO> newItems){
        Consumer<ItemDTO> lambdaSave = x -> repo.save(x);
        newItems.forEach(lambdaSave);
    }

    public ItemDTO getItem(String id){
        return repo.findById(id).orElseThrow(() -> new ItemNotFoundException(id));
    }
    
    public List<ItemDTO> getItems(){
        return repo.findAll();
    }

    public void deleteItem(String id){
        repo.deleteById(id);
    }
    
}

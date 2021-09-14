package com.mercadolibre.api.services;

import java.util.List;
import java.util.function.Consumer;

import com.mercadolibre.api.database.ItemRepository;
import com.mercadolibre.api.dtos.ItemDTO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Service
public class ItemServices {

    @Autowired
    private ItemRepository repo; 

    private static final Logger log = LoggerFactory.getLogger(ItemServices.class);

    public ItemDTO newItem(ItemDTO newItem){
        log.debug(newItem.toString());
        return repo.save(newItem);
    }

    public void newItems(List<ItemDTO> newItems){
        Consumer<ItemDTO> lambdaSave = x -> repo.save(new ItemDTO(x.getId(), x.getPrice()));
        newItems.forEach(lambdaSave);
    }
    
    public List<ItemDTO> getItems(){
        return repo.findAll();
    }

    public void deleteItem(String id){
        repo.deleteById(id);
    }
    
}

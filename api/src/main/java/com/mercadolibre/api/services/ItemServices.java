package com.mercadolibre.api.services;

import java.util.List;
import java.util.function.Consumer;

import com.mercadolibre.api.database.ItemRepository;
import com.mercadolibre.api.dtos.ItemDTO;
import com.mercadolibre.api.errors.ItemExistsException;
import com.mercadolibre.api.errors.ItemNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.stereotype.Service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Service
public class ItemServices {

    @Autowired
    private ItemRepository repo; 

    private static final Logger log = LoggerFactory.getLogger(ItemServices.class);

    public ItemDTO newItem(ItemDTO newItem){
        ExampleMatcher  itemMatcher = ExampleMatcher.matching()
        .withMatcher("id", ExampleMatcher.GenericPropertyMatchers.contains().ignoreCase());
        Example<ItemDTO> ex = Example.of(newItem,itemMatcher);
        if(repo.exists(ex)){
            log.info(String.format("%s already exists", newItem.toString()));
            throw new ItemExistsException(newItem.getId());
        }
        return repo.save(newItem);
    }

    public void newItems(List<ItemDTO> newItems){
        ExampleMatcher  itemMatcher = ExampleMatcher.matching()
        .withMatcher("id", ExampleMatcher.GenericPropertyMatchers.contains().ignoreCase());
        Consumer<ItemDTO> lambdaValidate = x -> {
            ItemDTO newItem = new ItemDTO(x.getId(), x.getPrice());
            Example<ItemDTO> ex = Example.of(newItem,itemMatcher);
            if(repo.exists(ex)){
                log.info(String.format("%s already exists", newItem.toString()));
                throw new ItemExistsException(newItem.getId());
            }
        };
        newItems.forEach(lambdaValidate);

        Consumer<ItemDTO> lambdaSave = x -> repo.save(new ItemDTO(x.getId(), x.getPrice()));
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

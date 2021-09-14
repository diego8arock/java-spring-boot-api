package com.mercadolibre.api.services;

import java.util.List;

import com.mercadolibre.api.database.ItemRepository;
import com.mercadolibre.api.database.UserItemRepository;
import com.mercadolibre.api.database.UserRepository;
import com.mercadolibre.api.dtos.ItemDTO;
import com.mercadolibre.api.dtos.UserDTO;
import com.mercadolibre.api.dtos.UserItemDTO;
import com.mercadolibre.api.models.FavoritesCount;
import com.mercadolibre.api.models.UserItem;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Service
public class UserItemServices {

    @Autowired
    private UserItemRepository repo;
    @Autowired
    private UserRepository userRepo;
    @Autowired 
    private ItemRepository itemRepo; 

    private static final Logger log = LoggerFactory.getLogger(UserItemServices.class);

    public UserItemDTO addUserItem(UserItem newUserItem) {
        
        log.debug(newUserItem.toString());
        UserDTO user = userRepo.findById(newUserItem.getUserId()).get();
        ItemDTO item = itemRepo.findById(newUserItem.getItemId()).get();
        UserItemDTO userItem = new UserItemDTO(user, item);
        return repo.save(userItem);

    }

    public void deleteUserItem(Long id) {
        repo.deleteById(id);
    }

    public List<FavoritesCount> getFavoritesStats() {
        
       return repo.favoritesCount();        
    }
    
}

package com.mercadolibre.api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import com.mercadolibre.api.dtos.UserDTO;
import com.mercadolibre.api.dtos.UserItemDTO;
import com.mercadolibre.api.models.UserItem;
import com.mercadolibre.api.services.UserItemServices;
import com.mercadolibre.api.services.UserServices;

@RestController
public class UserController {
    
    @Autowired
    UserServices services;

    @Autowired
    UserItemServices userItemServices;

    @PostMapping("/user")
    UserDTO newUser(@RequestBody UserDTO newUser){
        return services.newUser(newUser);
    }

    @GetMapping("/user")
    List<UserDTO> getUsers(){
        return services.getUsers(); 
    }

    @DeleteMapping("/user/{id}")
    void deleteUser(@PathVariable Long id){
        services.deleteUser(id);
    }

    @PostMapping("/user/favorite/add") 
    UserItemDTO addFavorite(@RequestBody UserItem newUserItemDTO)  {
        return userItemServices.addUserItem(newUserItemDTO);
    }

    @PostMapping("/user/favorite/remove/{id}") 
    void removeFavorite(@PathVariable Long id) {
        userItemServices.deleteUserItem(id);
    }
    
}

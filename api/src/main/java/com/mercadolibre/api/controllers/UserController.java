package com.mercadolibre.api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import javax.validation.Valid;

import com.mercadolibre.api.dtos.UserDTO;
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
    ResponseEntity<String> newUser(@RequestBody @Valid UserDTO newUser){
        services.newUser(newUser);
        return ResponseEntity.ok(String.format("User %s was registered", newUser.getEmail()));          
    }

    @GetMapping("/user/{id}")
    UserDTO getUser(@PathVariable Long id){
        return services.getUser(id); 
    }

    @GetMapping("/user")
    List<UserDTO> getUsers(){
        return services.getUsers(); 
    }

    @DeleteMapping("/user/{id}")
     ResponseEntity<String>deleteUser(@PathVariable Long id){
        services.deleteUser(id);
        return ResponseEntity.ok(String.format("User %s was deleted", id)); 
    }

    @PostMapping("/user/favorite/add") 
    ResponseEntity<String> addFavorite(@RequestBody @Valid UserItem newUserItemDTO)  {
        userItemServices.addUserItem(newUserItemDTO);
        return ResponseEntity.ok(String.format("Item id %s was added to favorites by user id %s", newUserItemDTO.getItemId(), newUserItemDTO.getUserId())); 
    }

    @DeleteMapping("/user/favorite/remove") 
    ResponseEntity<String> removeFavorite(@RequestBody @Valid UserItem oldUserItemDTO) {
        userItemServices.deleteUserItem(oldUserItemDTO);
        return ResponseEntity.ok(String.format("Favorite id %s from user id %s was removed", oldUserItemDTO.getItemId(), oldUserItemDTO.getUserId())); 
    }
    
}

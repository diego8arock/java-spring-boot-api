package com.mercadolibre.api.services;

import java.util.List;

import com.mercadolibre.api.database.UserRepository;
import com.mercadolibre.api.dtos.UserDTO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServices {

    @Autowired
    private UserRepository repo;

    public UserDTO newUser(UserDTO newUser){
        return repo.save(newUser);
    }

    public List<UserDTO> getUsers(){
        return repo.findAll(); 
    }

    public void deleteUser(Long id){
        repo.deleteById(id);
    }

}

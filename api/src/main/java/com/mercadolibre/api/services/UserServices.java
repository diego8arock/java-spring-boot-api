package com.mercadolibre.api.services;

import java.util.List;

import com.mercadolibre.api.database.UserRepository;
import com.mercadolibre.api.dtos.UserDTO;
import com.mercadolibre.api.errors.UserExistsException;
import com.mercadolibre.api.errors.UserNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.stereotype.Service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Service
public class UserServices {

    @Autowired
    private UserRepository repo;

    private static final Logger log = LoggerFactory.getLogger(ItemServices.class);

    public UserDTO newUser(UserDTO newUser){
        ExampleMatcher  userMatcher = ExampleMatcher.matching()
        .withIgnorePaths("id") 
        .withMatcher("email", ExampleMatcher.GenericPropertyMatchers.contains().ignoreCase());
        Example<UserDTO> ex = Example.of(newUser,userMatcher);
        if(repo.exists(ex)){
            log.info(String.format("%s already exists", newUser.toString()));
            throw new UserExistsException(newUser.getEmail());
        }
        return repo.save(newUser);
    }

    public UserDTO getUser(Long id){
        return repo.findById(id).orElseThrow(() -> new UserNotFoundException(id)); 
    }

    public List<UserDTO> getUsers(){
        return repo.findAll(); 
    }

    public void deleteUser(Long id){
        repo.deleteById(id);
    }

}

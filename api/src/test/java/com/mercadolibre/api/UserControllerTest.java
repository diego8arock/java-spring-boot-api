package com.mercadolibre.api;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mercadolibre.api.controllers.UserController;
import com.mercadolibre.api.database.UserRepository;
import com.mercadolibre.api.dtos.UserDTO;
import com.mercadolibre.api.services.UserItemServices;
import com.mercadolibre.api.services.UserServices;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(SpringExtension.class)
@WebMvcTest(controllers = UserController.class)
public class UserControllerTest {

    @Autowired
	private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @MockBean
    private UserRepository repo;

    @MockBean
    private UserServices services;

    @MockBean
    private UserItemServices userItemServices;

    @Test
	public void addNewUser_returnOK() throws Exception {
        UserDTO user = new UserDTO("test@gmail.com");
		mockMvc.perform(post("/user").content(objectMapper.writeValueAsString(user))
        .contentType("application/json"))        
        .andExpect(status().isOk());
	} 
    
}

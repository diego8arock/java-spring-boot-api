package com.mercadolibre.api.dtos;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "\"users\"")
public class UserDTO {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "user_seq") 
    private Long id;

    @Column(unique = true, nullable = false)  
    private String email; 

    @OneToMany(mappedBy = "user")
    private Set<UserItemDTO> favorites;

    public UserDTO(){ }    

    //constructor only as workaround for SB-JPA bug using @OneToMany https://github.com/spring-projects/spring-data-jpa/issues/1710
    public UserDTO(Long id) {
        this.id = id;
    }

    public UserDTO(String email){
        this.email = email;
    }  
    
    public UserDTO(Long id, String email) {
        this.id = id;
        this.email = email;
    }
    
    public String getEmail() {
       return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return String.format("User { id=%d, email=%s }",this.id, this.email);       
    }
}

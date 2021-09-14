package com.mercadolibre.api.database;

import com.mercadolibre.api.dtos.UserDTO;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserDTO, Long> {
    
}

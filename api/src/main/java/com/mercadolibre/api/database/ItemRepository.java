package com.mercadolibre.api.database;

import com.mercadolibre.api.dtos.ItemDTO;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemRepository extends JpaRepository<ItemDTO, String> {
    
}

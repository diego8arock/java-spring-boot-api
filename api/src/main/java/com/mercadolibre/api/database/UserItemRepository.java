package com.mercadolibre.api.database;

import java.util.List;

import com.mercadolibre.api.dtos.UserItemDTO;
import com.mercadolibre.api.models.FavoritesCount;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface UserItemRepository extends JpaRepository<UserItemDTO, Long> {
    
    @Query(value = "select items_id as itemId, count (1) as total from users_items group by items_id order by total desc limit 5", nativeQuery = true)
    public List<FavoritesCount> favoritesCount();

}

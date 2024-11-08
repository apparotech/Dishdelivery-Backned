package com.socialmore.dishdelivery.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.socialmore.dishdelivery.entity.Item;

@Repository
public interface  ItemRepository extends JpaRepository<Item, Integer>{
    
    public List<Item> findByItemName(String itemName);
}

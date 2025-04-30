package com.socialmore.dishdelivery.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.socialmore.dishdelivery.entity.Admin;

@Repository
public interface  AdminRepo  extends  JpaRepository<Admin, Integer> {
    
}

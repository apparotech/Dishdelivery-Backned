package com.socialmore.dishdelivery.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.socialmore.dishdelivery.entity.User;

@Repository
public interface  UserRepository  extends JpaRepository<User, Long> {
    Optional<User> findByUsername(String username);
    //Optional<User>
    // Optional<User>  findByEmail(String email);
    // boolean existsByEmail(String email);
     boolean existsByUsername(String username);
    
}

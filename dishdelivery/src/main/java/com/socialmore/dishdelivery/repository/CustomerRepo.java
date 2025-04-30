package com.socialmore.dishdelivery.repository;

import java.util.Optional;

import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.support.JpaRepositoryImplementation;

import com.socialmore.dishdelivery.entity.Customer;

@Repository
public interface CustomerRepo  extends  JpaRepositoryImplementation<Customer, Integer> {
    
   // Optional<Customer>  findByEmail(String email);

    public Customer findByMobileNumber(String mobileNo);
    //boolean existsByEmail(String email);
}

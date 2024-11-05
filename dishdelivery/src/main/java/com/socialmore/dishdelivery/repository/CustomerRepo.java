package com.socialmore.dishdelivery.repository;

import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.support.JpaRepositoryImplementation;
import com.socialmore.dishdelivery.entity.Customer;

@Repository
public interface CustomerRepo  extends  JpaRepositoryImplementation<Customer, Integer> {
    
    public Customer findByEmail(String email);

    public Customer findByMobileNumber(String mobileNo);
}

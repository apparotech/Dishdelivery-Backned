package com.socialmore.dishdelivery.service.Impl;

import org.springframework.stereotype.Service;

import com.socialmore.dishdelivery.entity.Address;
import com.socialmore.dishdelivery.entity.Customer;
import com.socialmore.dishdelivery.exception.CustomerNotFound;
import com.socialmore.dishdelivery.payloads.Customerdto;
import com.socialmore.dishdelivery.repository.CustomerRepo;
import com.socialmore.dishdelivery.service.CustomerService;

import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@AllArgsConstructor
@Slf4j
@Transactional
public class CustomerServiceImpl   implements  CustomerService{

    private CustomerRepo customerRepo ;

    @Override
    public Customer addCustomer(Customerdto customerdto) {

        // Map AddressDTO to Address entity
          Address address = new Address();
          address.setBuildingName(customerdto.getAddress().getBuildingName());
          address.setStreetNo(customerdto.getAddress().getStreetNo());
          address.setArea(customerdto.getAddress().getArea());
          address.setCity(customerdto.getAddress().getCity());
          address.setState(customerdto.getAddress().getState());
          address.setCountry(customerdto.getAddress().getCountry());
          address.setPinCode(customerdto.getAddress().getPinCode());

         Customer customer = new Customer();
           customer.setFirstName(customerdto.getFirstname());
           customer.setLastname(customerdto.getLastName());
           customer.setEmail(customerdto.getEmail());
           customer.setAge(customerdto.getAge());
           customer.setMobileNumber(customerdto.getMobileNumber());
          
           customer.setPassword(customerdto.getPassword());
           customer.setGender(customerdto.getGender());
           customer.setAddress(address); 
           return customerRepo.save(customer);

    }


    
    
}

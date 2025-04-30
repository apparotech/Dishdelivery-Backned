package com.socialmore.dishdelivery.service.Impl;


import java.util.Collections;

import org.modelmapper.ModelMapper;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.socialmore.dishdelivery.entity.Address;
import com.socialmore.dishdelivery.entity.Customer;
import com.socialmore.dishdelivery.entity.User;
import com.socialmore.dishdelivery.enuk.Role;
import com.socialmore.dishdelivery.payloads.Customerdto;
import com.socialmore.dishdelivery.repository.CustomerRepo;
import com.socialmore.dishdelivery.repository.UserRepository;
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
    private final PasswordEncoder passwordEncoder;
    private ModelMapper modelMapper;

    private UserRepository userRepository;

    @Override
    public Customerdto addCustomer(Customerdto customerdto) {

      if (userRepository.existsByUsername(customerdto.getUsername())) {
        log.warn("Username {} already exists", customerdto.getUsername());
        throw new IllegalArgumentException("Username already exists.");
    }

    // Create and save User
    User user = new User();
    user.setUsername(customerdto.getUsername());
    user.setPassword(passwordEncoder.encode(customerdto.getPassword()));
    user.setRoles(Collections.singleton(Role.CUSTOMER));
    userRepository.save(user);

    // Map Address
    Address address = mapAddress(customerdto);

    // Create and save Customer
    Customer customer = new Customer();
    customer.setFirstName(customerdto.getFirstname());
    customer.setLastName(customerdto.getLastName());
    customer.setAge(customerdto.getAge());
    customer.setMobileNumber(customerdto.getMobileNumber());
    customer.setAddress(address);
    customer.setUser(user);

    Customer savedCustomer = customerRepo.save(customer);

    // Map to DTO
   // return modelMapper.map(savedCustomer, Customerdto.class);
   Customerdto result = modelMapper.map(savedCustomer, Customerdto.class);
   result.setUsername(user.getUsername());
   result.setPassword(null);
   return result;
}

private Address mapAddress(Customerdto customerdto) {
    if (customerdto.getAddress() == null) return null;

    Address address = new Address();
    address.setBuildingName(customerdto.getAddress().getBuildingName());
    address.setStreetNo(customerdto.getAddress().getStreetNo());
    address.setArea(customerdto.getAddress().getArea());
    address.setCity(customerdto.getAddress().getCity());
    address.setState(customerdto.getAddress().getState());
    address.setCountry(customerdto.getAddress().getCountry());
    address.setPinCode(customerdto.getAddress().getPinCode());
    return address;

  

    }

    @Override
    public Customerdto editCustomerDetails(Integer customerId, Customerdto updatedCustomerDto) {
        //throw new UnsupportedOperationException("Not supported yet.");

        Customer  existingCustomer = customerRepo.findById(customerId)
        .orElseThrow(() -> new IllegalArgumentException("Customer not found with ID: " + customerId));

         // Update customer's basic details
    if (updatedCustomerDto.getFirstname() != null) {
      existingCustomer.setFirstName(updatedCustomerDto.getFirstname());
  }
  if (updatedCustomerDto.getLastName() != null) {
      existingCustomer.setLastName(updatedCustomerDto.getLastName());
  }
  if (updatedCustomerDto.getMobileNumber() != null) {
      existingCustomer.setMobileNumber(updatedCustomerDto.getMobileNumber());
  }
  if (updatedCustomerDto.getAge() != null) {
      existingCustomer.setAge(updatedCustomerDto.getAge());
  }

  // Update Address if provided
  if (updatedCustomerDto.getAddress() != null) {
      Address updatedAddress = mapAddress(updatedCustomerDto);
      existingCustomer.setAddress(updatedAddress);
  }

  // Save the updated customer to the repository
  Customer savedCustomer = customerRepo.save(existingCustomer);

  // Map the updated entity back to DTO
  Customerdto resultDto = modelMapper.map(savedCustomer, Customerdto.class);
  resultDto.setUsername(existingCustomer.getUser().getUsername());
  return resultDto;
    }

    


    
    
}

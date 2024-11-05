package com.socialmore.dishdelivery.service;

import com.socialmore.dishdelivery.entity.Customer;
import com.socialmore.dishdelivery.payloads.Customerdto;

public interface  CustomerService {

    public Customer addCustomer(Customerdto customerdto);
    
}

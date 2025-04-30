package com.socialmore.dishdelivery.service;

import com.socialmore.dishdelivery.payloads.Customerdto;

public interface  CustomerService {

    public Customerdto addCustomer(Customerdto customerdto);

    public Customerdto editCustomerDetails(Integer customerId, Customerdto updatedCustomerDto) ;
    
}

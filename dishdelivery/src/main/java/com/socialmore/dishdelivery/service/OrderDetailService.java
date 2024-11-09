package com.socialmore.dishdelivery.service;

import com.socialmore.dishdelivery.entity.Customer;
import com.socialmore.dishdelivery.entity.OrderDetails;
import com.socialmore.dishdelivery.exception.FoodCartException;
import com.socialmore.dishdelivery.exception.OrderException;
import java.util.List;
public interface  OrderDetailService {

    public OrderDetails addOrder(OrderDetails order) throws  OrderException;

    public OrderDetails removeOrder(Integer orderId) throws OrderException;

    public OrderDetails updateOrder(OrderDetails order) throws OrderException;

	public OrderDetails viewOrder(Integer OrderId) throws OrderException;

//	public List<OrderDetails> viewAllOrders(Restaurant res) throws OrderException;

	public List<OrderDetails> viewAllOrders(Customer customer) throws OrderException,FoodCartException;
    
}

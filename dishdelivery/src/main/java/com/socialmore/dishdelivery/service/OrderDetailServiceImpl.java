package com.socialmore.dishdelivery.service;

import java.util.Optional;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.socialmore.dishdelivery.entity.Customer;
import com.socialmore.dishdelivery.entity.FoodCart;
import com.socialmore.dishdelivery.entity.OrderDetails;
import com.socialmore.dishdelivery.exception.FoodCartException;
import com.socialmore.dishdelivery.exception.OrderException;
import com.socialmore.dishdelivery.repository.FoodCartRepo;
import com.socialmore.dishdelivery.repository.OrderDetailRepo;

@Service
public class OrderDetailServiceImpl  implements  OrderDetailService{

    @Autowired
    private OrderDetailRepo orderDetailRepo;

    @Autowired
    private FoodCartRepo foodCartRepo;


    public OrderDetails addOrder(OrderDetails order) throws  OrderException {

        if(order != null) {
            OrderDetails savedOrder=	orderDetailRepo.save(order);
            return savedOrder;
        }
        else {
            throw new OrderException("Order Not Added.....!");
        }
    }

    public OrderDetails removeOrder (Integer OrderId)throws OrderException {

        Optional<OrderDetails> opt = orderDetailRepo.findById(OrderId);

        if(opt.isPresent()) {
            OrderDetails deletedOrder = opt.get();

            orderDetailRepo.delete(deletedOrder);
            return deletedOrder;
        } else {
            throw new OrderException("Order does not exist...!");
        }
    }


    @Override
	public OrderDetails updateOrder(OrderDetails order) throws OrderException {
		
		Optional<OrderDetails> opt = orderDetailRepo.findById(order.getOrderId());
		
		if (opt.isPresent()) {
			
			return orderDetailRepo.save(order);
			
			 
		} else {
			
			throw new OrderException("Order does not exist...!");
			
		}
	}

	@Override
	public OrderDetails viewOrder(Integer OrderId) throws OrderException {
		
		Optional<OrderDetails> opt = orderDetailRepo.findById(OrderId);
		
		if (opt.isPresent()) {
			
			OrderDetails vieworder = opt.get();
			
			return vieworder;
			
		} else {
			
			throw new OrderException("Order does not exist...!");
			
		}
	}

//	@Override
//	public List<OrderDetails> viewAllOrders(Restaurant res) throws OrderException {
//			       
//		
//		Optional<Restaurant>  rest= restRepo.findById(res.getRestaurantId());
//		
//		List<Item> items = rest.get().getItems();
//		
//		
//		
//		
//		
//		
//		// TODO Auto-generated method stub
//		return null;
//	}

	@Override
	public List<OrderDetails> viewAllOrders(Customer customer) throws OrderException,FoodCartException {
		// TODO Auto-generated method stub
		
		FoodCart foodCart = foodCartRepo.findByCustomer(customer);
		
		if(foodCart==null) {
			throw new FoodCartException("FoodCart not found....");
		}
		
		List<OrderDetails> orderdetail =orderDetailRepo.findByCart(foodCart);
		
		if(orderdetail.size()==0) {
			throw new OrderException("Order Detail Not found....");
		}
		
		
		
		return orderdetail;
	}
    
}

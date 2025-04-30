package com.socialmore.dishdelivery.service;

import com.socialmore.dishdelivery.entity.Bill;
import com.socialmore.dishdelivery.entity.BillDto;

import java.util.List;

import com.socialmore.dishdelivery.exception.BillException;

public interface  BillService {

    public BillDto addBill(Bill bill) throws BillException;

	public Bill updateBill(Bill bill) throws BillException;

	public Bill removeBill(Integer bid) throws BillException;

	public Bill viewBill(Integer bid) throws BillException;

	public List<Bill> viewAllBills(String startDate, String endDate) throws BillException;
	
	public Double CalculateTotalCost(Integer id)throws BillException;
    
}

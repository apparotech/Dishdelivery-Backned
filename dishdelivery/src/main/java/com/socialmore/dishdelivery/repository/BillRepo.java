package com.socialmore.dishdelivery.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.socialmore.dishdelivery.entity.Bill;

@Repository
public interface  BillRepo  extends  JpaRepository<Bill, Integer> {

    @Query("from Bill where billDate<=?1 and billDate>=?2")
	public java.util.List<Bill> getBillByDate(String startDate,String endDate);
    
}

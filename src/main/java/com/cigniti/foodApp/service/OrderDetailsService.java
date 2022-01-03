package com.cigniti.foodApp.service;

import java.util.List;

import com.cigniti.foodApp.entity.OrderDetails;

public interface OrderDetailsService {

	public List<OrderDetails> getAllOrderDetails();
	public OrderDetails saveOrderDetails(OrderDetails orderDetails);
	public OrderDetails findByOrderDetailsId(int id);
	public void deleteByOrderDetailsId(int id);
	
}

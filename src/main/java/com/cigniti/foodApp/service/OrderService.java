package com.cigniti.foodApp.service;

import java.util.List;

import com.cigniti.foodApp.entity.Order;

public interface OrderService {
	
	public List<Order> getAllOrders();
	public Order saveOrder(Order order);
	public Order findByOrderId(int orderId);
	public void deleteByOrderId(int orderId);
	

}

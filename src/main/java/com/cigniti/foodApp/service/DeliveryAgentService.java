package com.cigniti.foodApp.service;

import java.util.List;

import com.cigniti.foodApp.entity.DeliveryAgent;

public interface DeliveryAgentService {
	
	public List<DeliveryAgent> getAllDeliveryAgents();
	public DeliveryAgent saveDeliveryAgent(DeliveryAgent deliveryAgent);
	public DeliveryAgent getDeliveryAgentById(int id);
	public void deleteDeliveryAgentById(int id);
	
	

}

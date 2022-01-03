package com.cigniti.foodApp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cigniti.foodApp.entity.DeliveryAgent;
import com.cigniti.foodApp.service.DeliveryAgentService;

@RestController

@RequestMapping("/deliveryAgents")
public class DeliveryAgentController {

	@Autowired
	DeliveryAgentService daService;

	@GetMapping("/list")
	public List<DeliveryAgent> getAllDeliveryAgents() {

		List<DeliveryAgent> deliveryAgents = daService.getAllDeliveryAgents();
		return deliveryAgents;

	}

	@PostMapping("/save")
	public DeliveryAgent saveDeliveryAgent(@RequestBody DeliveryAgent deliveryAgent) {
		daService.saveDeliveryAgent(deliveryAgent);

		return deliveryAgent;

	}

	@PutMapping("/edit")
	public DeliveryAgent updateDeliveryAgent(@RequestBody DeliveryAgent deliveryAgent) {
		daService.saveDeliveryAgent(deliveryAgent);

		return deliveryAgent;
	}

	@DeleteMapping("/delete/{id}")
	public String delete(@PathVariable int id) {

		DeliveryAgent deliveryAgent = daService.getDeliveryAgentById(id);
		if (deliveryAgent == null) {
			throw new RuntimeException("DeliveryAgent not found with id" + id);
		}

		daService.deleteDeliveryAgentById(id);
		return "Deleted DeliveryAgent with id :" + id;
	}

}

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

import com.cigniti.foodApp.entity.OrderDetails;
import com.cigniti.foodApp.service.OrderDetailsService;

@RestController

@RequestMapping("/orderDetails")
public class OrderDetailsController {

	@Autowired
	OrderDetailsService odService;

	@GetMapping("/list")
	public List<OrderDetails> getAllOrderDetails() {

		List<OrderDetails> orderDetailsList = odService.getAllOrderDetails();
		return orderDetailsList;

	}

	@PostMapping("/save")
	public OrderDetails saveOrderDetails(@RequestBody OrderDetails orderDetails) {
		odService.saveOrderDetails(orderDetails);

		return orderDetails;

	}

	@PutMapping("/edit")
	public OrderDetails updateOrderDetails(@RequestBody OrderDetails orderDetails) {
		odService.saveOrderDetails(orderDetails);

		return orderDetails;
	}

	@DeleteMapping("/delete/{id}")
	public String delete(@PathVariable int id) {

		OrderDetails orderDetails = odService.findByOrderDetailsId(id);
		if (orderDetails == null) {
			throw new RuntimeException("OrderDetails not found with id" + id);
		}

		odService.deleteByOrderDetailsId(id);
		return "Deleted OrderDetails with id :" + id;
	}

}

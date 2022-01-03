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

import com.cigniti.foodApp.entity.ItemAvailability;
import com.cigniti.foodApp.service.ItemAvailabilityService;

@RestController
@RequestMapping("/itemAvailability")
public class ItemAvailabilityController {
	@Autowired
	ItemAvailabilityService itemAvailService;

	@GetMapping("/list")
	public List<ItemAvailability> findAll() {

		List<ItemAvailability> itemAvailList = itemAvailService.findAll();
		return itemAvailList;

	}

	@PostMapping("/save")
	public ItemAvailability save(@RequestBody ItemAvailability itemAvailability) {
		itemAvailService.save(itemAvailability);

		return itemAvailability;

	}

	@PutMapping("/edit")
	public ItemAvailability update(@RequestBody ItemAvailability itemAvailability) {
		itemAvailService.save(itemAvailability);

		return itemAvailability;
	}

	@DeleteMapping("/delete/{id}")
	public String delete(@PathVariable int id) {

		ItemAvailability itemAvailability = itemAvailService.findByItemAvailId(id);
		if (itemAvailability == null) {
			throw new RuntimeException(id + " Not Found");
		}

		itemAvailService.deleteByItemAvailId(id);
		return "Deleted Sussesfully";
	}

}

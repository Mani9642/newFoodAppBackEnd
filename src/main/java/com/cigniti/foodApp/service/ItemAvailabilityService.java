package com.cigniti.foodApp.service;

import java.util.List;

import com.cigniti.foodApp.entity.ItemAvailability;

public interface ItemAvailabilityService {

	public List<ItemAvailability> findAll();

	public ItemAvailability save(ItemAvailability itemAvailability);

	public ItemAvailability findByItemAvailId(int id);

	public void deleteByItemAvailId(int id);

}

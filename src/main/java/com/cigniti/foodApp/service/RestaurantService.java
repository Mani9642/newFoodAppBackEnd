package com.cigniti.foodApp.service;

import java.util.List;

import com.cigniti.foodApp.entity.Restaurant;

public interface RestaurantService {

	public List<Restaurant> getAllRestaurants();
	
	public Restaurant saveRestaurant(Restaurant restaurant);
	
	public Restaurant findByRestId(int restId);
	
	public void deleteRestaurant(int restId);
	
	public List<Restaurant> searchByName(String seachWord);
	

}

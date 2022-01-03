package com.cigniti.foodApp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cigniti.foodApp.entity.Restaurant;

public interface RestaurantRepository extends JpaRepository<Restaurant, Integer> {
	
	List<Restaurant> findByRestNameContainsAllIgnoreCase(String searchWord);

}

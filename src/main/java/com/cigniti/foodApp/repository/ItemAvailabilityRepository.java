package com.cigniti.foodApp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cigniti.foodApp.entity.ItemAvailability;

public interface ItemAvailabilityRepository extends JpaRepository<ItemAvailability, Integer> {

}

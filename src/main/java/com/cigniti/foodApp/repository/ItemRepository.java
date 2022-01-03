package com.cigniti.foodApp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cigniti.foodApp.entity.Item;

public interface ItemRepository extends JpaRepository<Item, Integer> {

	List<Item> findByRestId(int id);

	List<Item> findByCategoryId(int id);
	
	List<Item> findByItemNameContainsAllIgnoreCase(String searchWord);

}

package com.cigniti.foodApp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cigniti.foodApp.entity.Category;

public interface CategoryRepository extends JpaRepository<Category, Integer> {
	
	List<Category> findByCategoryNameContainsAllIgnoreCase(String searchword);

}

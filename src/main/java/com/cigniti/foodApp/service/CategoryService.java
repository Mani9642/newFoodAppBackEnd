package com.cigniti.foodApp.service;

import java.util.List;

import com.cigniti.foodApp.entity.Category;

public interface CategoryService {

	public List<Category> getAllCategories();

	public Category saveCategory(Category category);

	public Category findByCategoryId(int categoryId);

	public void deleteCategory(int categoryId);
	
	public List<Category> search(String searchWord);

}

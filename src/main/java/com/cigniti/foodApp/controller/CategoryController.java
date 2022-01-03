package com.cigniti.foodApp.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.cigniti.foodApp.entity.Category;
import com.cigniti.foodApp.service.CategoryService;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/categories")
public class CategoryController {

	@Autowired
	CategoryService catService;

	@GetMapping("/list")
	public List<Category> getAllRestaurants() {

		List<Category> categories = catService.getAllCategories();
		return categories;

	}

	@PostMapping("/save")
	public Category saveRestaurant(@RequestBody Category category, HttpServletRequest request) {

		request = ((ServletRequestAttributes) RequestContextHolder.currentRequestAttributes()).getRequest();

		String ip = request.getRemoteAddr();
		category.setIpAddress(ip);
		catService.saveCategory(category);

		return category;

	}

	@PutMapping("/edit")
	public Category updateCategory(@RequestBody Category category) {
		catService.saveCategory(category);

		return category;
	}

	@DeleteMapping("/delete/{id}")
	public String delete(@PathVariable int id) {

		Category category = catService.findByCategoryId(id);
		if (category == null) {
			throw new RuntimeException("Category not found with id" + id);
		}

		catService.deleteCategory(id);
		return "Deleted category with id :" + id;
	}
	
	@GetMapping("/search/{name}")
	public List<Category> search(@PathVariable String name){
		
		return catService.search(name);
	}

}

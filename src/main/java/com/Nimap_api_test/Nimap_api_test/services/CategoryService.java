package com.Nimap_api_test.Nimap_api_test.services;

import java.util.List;

import com.Nimap_api_test.Nimap_api_test.payloads.CategoryDto;

public interface CategoryService {

	// create
	CategoryDto createCategory (CategoryDto category);
	
	// update
	CategoryDto updateCategory(CategoryDto category, Integer categoryId);
	
	// get
	CategoryDto getCategoryById (Integer categoryId);
	
	// getAll
	List<CategoryDto> getAllCategory();
	
	// Delete
	void deleteCategory (Integer categoryId);


	
}

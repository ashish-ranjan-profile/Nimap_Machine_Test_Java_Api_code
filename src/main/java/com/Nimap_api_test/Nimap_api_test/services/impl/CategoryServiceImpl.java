package com.Nimap_api_test.Nimap_api_test.services.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Nimap_api_test.Nimap_api_test.entities.Category;
import com.Nimap_api_test.Nimap_api_test.payloads.CategoryDto;
import com.Nimap_api_test.Nimap_api_test.repositories.CategoryRepo;
import com.Nimap_api_test.Nimap_api_test.services.CategoryService;
import com.Nimap_api_test.Nimap_api_test.exceptions.*;

@Service
public class CategoryServiceImpl implements CategoryService {

	@Autowired
	private CategoryRepo categoryRepo;
	
	@Autowired
	private ModelMapper modelMapper;
	
	@Override
	public CategoryDto createCategory(CategoryDto categoryDto) {

		Category category = this.modelMapper.map(categoryDto, Category.class);
		Category saveCategory = this.categoryRepo.save(category);
		return this.modelMapper.map(saveCategory, CategoryDto.class);
	}

	@Override
	public CategoryDto updateCategory(CategoryDto categoryDto, Integer categoryId) {

		Category category = this.categoryRepo.findById(categoryId)
				.orElseThrow(()-> new ResourceNotFoundException("Category","Id",categoryId));
		
		category.setCategoryName(categoryDto.getCategoryName());
		category.setDescription(categoryDto.getDescription());
		
		Category updateCategory = this.categoryRepo.save(category);
		
		return this.modelMapper.map(updateCategory, CategoryDto.class);
	}


	@Override
	public CategoryDto getCategoryById(Integer categoryId) {

		Category category = this.categoryRepo.findById(categoryId)
				.orElseThrow(()-> new ResourceNotFoundException("Category","Id",categoryId));
		
		return this.modelMapper.map(category, CategoryDto.class);
	}

	
	@Override
	public List<CategoryDto> getAllCategory() {

		List<Category> categories = this.categoryRepo.findAll();
		
		List<CategoryDto> categoryDtos = categories.stream()
				.map((category)-> this.modelMapper.map(category, CategoryDto.class)).collect(Collectors.toList());
		
		return categoryDtos;
	}

	@Override
	public void deleteCategory(Integer categoryId) {

		Category category = this.categoryRepo.findById(categoryId)
		.orElseThrow(()-> new ResourceNotFoundException("Category","Id",categoryId));
		
		this.categoryRepo.delete(category);
		
	}
	
}

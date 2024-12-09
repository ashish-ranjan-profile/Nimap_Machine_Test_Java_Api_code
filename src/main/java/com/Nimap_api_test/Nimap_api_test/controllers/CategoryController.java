package com.Nimap_api_test.Nimap_api_test.controllers;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Nimap_api_test.Nimap_api_test.payloads.CategoryDto;
import com.Nimap_api_test.Nimap_api_test.services.CategoryService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api")
public class CategoryController {

	@Autowired
	private CategoryService categoryService;
	
	//POST - Create Product
		@PostMapping("/categories")
		public ResponseEntity<CategoryDto> createCategory(@Valid @RequestBody CategoryDto categoryDto){

			CategoryDto createCategoryDto = this.categoryService.createCategory(categoryDto);
			
			return new ResponseEntity<>(createCategoryDto,HttpStatus.CREATED);
			
		}
		
		//PUT - Update Product
		@PutMapping("/categories/{categoryId}")
		public ResponseEntity<CategoryDto> updateCategory(@Valid @RequestBody CategoryDto categoryDto, @PathVariable Integer categoryId){

		CategoryDto updateCategoryDto = this.categoryService.updateCategory(categoryDto,categoryId);
					
		return new ResponseEntity<>(updateCategoryDto,HttpStatus.OK);
					
		}
		//Delete - Update Product
		@DeleteMapping("/categories/{categoryId}")
		public ResponseEntity<Object> deleteCategory(@PathVariable Integer categoryId){

	      this.categoryService.deleteCategory(categoryId);
							
			return new ResponseEntity<Object>(Map.of("Category deleted successfully",categoryId),HttpStatus.OK);
							
		}		
		
		// Get category
		@GetMapping("/categories/{categoryId}")
		public ResponseEntity<CategoryDto> getCategory(@PathVariable Integer categoryId){
		
			CategoryDto categoryDto = this.categoryService.getCategoryById(categoryId);
			return new ResponseEntity<CategoryDto>(categoryDto,HttpStatus.OK);
		}
		
		
		// Get category
		@GetMapping("/categories")
		public ResponseEntity<List<CategoryDto>> getCategories(){
				
			List<CategoryDto> categories = this.categoryService.getAllCategory();
			return ResponseEntity.ok(categories);
		}	
		
		
}

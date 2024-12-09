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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.Nimap_api_test.Nimap_api_test.payloads.ProductDto;
import com.Nimap_api_test.Nimap_api_test.services.ProductService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api")
public class ProductController {

	@Autowired
	private ProductService productService;
	
	//POST - Create Product
	@PostMapping("/products")
	public ResponseEntity<ProductDto> createProduct(@Valid @RequestBody ProductDto productDto){

		ProductDto createProductDto = this.productService.createProduct(productDto);
		
		return new ResponseEntity<>(createProductDto,HttpStatus.CREATED);
		
	}
	
	//PUT - Update Product
	@PutMapping("/products/{productId}")
	public ResponseEntity<ProductDto> updateProduct (@Valid @RequestBody ProductDto productDto, @PathVariable Integer productId){
		
		ProductDto updatedProduct = this.productService.updateProduct(productDto, productId);
		
		return new ResponseEntity<>(updatedProduct,HttpStatus.OK);
		
	}
	
	//DELETE - Delete Product 
	
	@DeleteMapping("/products/{productId}")
	public ResponseEntity<?> deleteProduct(@PathVariable Integer productId){
		this.productService.deleteProduct(productId);
		
		return new ResponseEntity<Object>(Map.of("Product deleted successfully",productId),HttpStatus.OK);
	}
	
	
	//GET - Get Product
	
	@GetMapping("/products")
	public ResponseEntity<List<ProductDto>> getAllProduct(
			@RequestParam(value = "page", defaultValue = "0",required = false)Integer pageNumber,
			@RequestParam(value = "pageSize", defaultValue = "5",required = false)Integer pageSize)
	{
		
		
		return ResponseEntity.ok(this.productService.getAllProduct(pageNumber,pageSize));
		
	}
	
	//GET - Get single Product
	

	@GetMapping("/products/{productId}")
	public ResponseEntity<ProductDto> getSingleProduct(@PathVariable Integer productId)
	{
		return ResponseEntity.ok(this.productService.getProductById(productId));
		
	}
	
}

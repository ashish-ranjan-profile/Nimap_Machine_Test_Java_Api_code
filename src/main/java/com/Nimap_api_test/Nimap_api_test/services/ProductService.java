package com.Nimap_api_test.Nimap_api_test.services;

import java.util.List;

import com.Nimap_api_test.Nimap_api_test.payloads.ProductDto;

public interface ProductService {

	ProductDto createProduct (ProductDto product);
	
	ProductDto updateProduct (ProductDto product, Integer productId);
	
	ProductDto getProductById (Integer productId);
	
	List<ProductDto> getAllProduct(Integer pageNumber,Integer pageSize);
	
	void deleteProduct (Integer productId);


	
}

package com.Nimap_api_test.Nimap_api_test.services.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.Nimap_api_test.Nimap_api_test.entities.Product;
import com.Nimap_api_test.Nimap_api_test.payloads.ProductDto;
import com.Nimap_api_test.Nimap_api_test.repositories.ProductRepo;
import com.Nimap_api_test.Nimap_api_test.services.ProductService;
import com.Nimap_api_test.Nimap_api_test.exceptions.*;

@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	private ProductRepo productRepo;
	@Autowired
	private ModelMapper modelMapper;
	
	@Override
	public ProductDto createProduct(ProductDto productDto) {

		Product product = this.dtoToProduct(productDto);
		Product saveProduct = this.productRepo.save(product);
		return this.productToDto(saveProduct);
	}

	@Override
	public ProductDto updateProduct(ProductDto productDto, Integer productId) {

		Product product = this.productRepo.findById(productId)
				.orElseThrow(()-> new ResourceNotFoundException("Product","Id",productId));
		
		product.setProductName(productDto.getProductName());
		product.setBrand(productDto.getBrand());
		product.setPrice(productDto.getPrice());
		product.setDescription(productDto.getDescription());
		
		Product updateProduct = this.productRepo.save(product);
		ProductDto productDto1 = this.productToDto(updateProduct);
		return productDto1;
	}


	@Override
	public ProductDto getProductById(Integer productId) {

		Product product = this.productRepo.findById(productId)
				.orElseThrow(()-> new ResourceNotFoundException("Product","Id",productId));
		
		return this.productToDto(product);
	}

	
	@Override
	public List<ProductDto> getAllProduct(Integer pageNumber, Integer pageSize) {

		Pageable p = PageRequest.of(pageNumber, pageSize);
		
		Page<Product> pageProduct = this.productRepo.findAll(p);
		List<Product> allProduct = pageProduct.getContent();
		List<ProductDto> productDtos = allProduct.stream()
				.map(product-> this.productToDto(product)).collect(Collectors.toList());
		
		return productDtos;
	}

	@Override
	public void deleteProduct(Integer productId) {

		Product product = this.productRepo.findById(productId)
		.orElseThrow(()-> new ResourceNotFoundException("Product","Id",productId));
		
		this.productRepo.delete(product);
		
	}
	
	
	private ProductDto productToDto(Product product) {
		
		ProductDto productDto = this.modelMapper.map(product, ProductDto.class);
		
		
		return productDto;
		
	}
	
		private Product dtoToProduct(ProductDto productToDto) {
		
		Product product = this.modelMapper.map(productToDto,Product.class );
		

		return product;
		}
}

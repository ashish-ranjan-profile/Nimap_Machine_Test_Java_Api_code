package com.Nimap_api_test.Nimap_api_test.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotEmpty;

@Entity
@Table(name="Product_Info")
public class Product {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	@Column(name = "Product_Name",nullable = false)
	@NotEmpty
	private String productName;
	
	@Column(name = "Product_Brand",nullable = false)
	@NotEmpty
	private String brand;
	
	@Column(name = "Product_Price",nullable = false)
	
	private double price;
	
	@Column(name = "Description",nullable = false)
	@NotEmpty
	private String description;
	
	@Column(name = "Product_type",nullable = false)
	@NotEmpty
	private String type;
	@ManyToOne
	private Category category;
	
	// Getter & Setter Methods:-
	
	
	public String getType() {
		return type;
	}





	public void setType(String type) {
		this.type = type;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
}

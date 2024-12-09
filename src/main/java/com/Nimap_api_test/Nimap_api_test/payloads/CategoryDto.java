package com.Nimap_api_test.Nimap_api_test.payloads;

public class CategoryDto {

	private long id;
	private String categoryName;
	private String description;
	
	
	public CategoryDto() {
		super();
	}
	// Getter & Setter Methods:-
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getCategoryName() {
		return categoryName;
	}
	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	
	
}
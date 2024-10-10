package com.example.NimapInfotechMTest.entity;

import lombok.Data;

@Data
public class ProductDTO {

	private long id;
	private String prodName;
	private int categoryId;
	private double price;
	private String color;
	private String size;
	private String description;
	private String imgName;
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getProdName() {
		return prodName;
	}
	public void setProdName(String prodName) {
		this.prodName = prodName;
	}
	public int getCategoryId() {
		return categoryId;
	}
	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public String getSize() {
		return size;
	}
	public void setSize(String size) {
		this.size = size;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getImgName() {
		return imgName;
	}
	public void setImgName(String imgName) {
		this.imgName = imgName;
	}
	@Override
	public String toString() {
		return "ProductDTO [id=" + id + ", prodName=" + prodName + ", categoryId=" + categoryId + ", price=" + price
				+ ", color=" + color + ", size=" + size + ", description=" + description + ", imgName=" + imgName + "]";
	}
	
	
	
	
}

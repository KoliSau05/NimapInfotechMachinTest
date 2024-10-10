package com.example.NimapInfotechMTest.service;

import java.util.List;
import java.util.Optional;

import com.example.NimapInfotechMTest.entity.Products;

public interface ProductServiceInterface {

	public List<Products> getAllProducts();
	public void addProduct(Products prod);
	public void deleteProductById(long id);
	public Optional<Products> updateProductById(long id);
	public List<Products> getAllProductsByCategoryId(int id);
}

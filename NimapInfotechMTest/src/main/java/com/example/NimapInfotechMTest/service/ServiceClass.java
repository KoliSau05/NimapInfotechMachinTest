package com.example.NimapInfotechMTest.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.NimapInfotechMTest.Repository.CategoryRepository;
import com.example.NimapInfotechMTest.Repository.ProductRepository;
import com.example.NimapInfotechMTest.entity.Category;
import com.example.NimapInfotechMTest.entity.Products;

@Service
public class ServiceClass implements CategoryServiceInerface , ProductServiceInterface {

	// Category Section
	@Autowired
	private CategoryRepository catRepo;
	
	@Override
	public void addCategory(Category cat) {
		catRepo.save(cat);
	}
	@Override
	public List<Category> getAllCategory() {
		return catRepo.findAll();
	}
	@Override
	public void deleteCategoryById(int id) {
		catRepo.deleteById(id);	
	}
    @Override
	public Optional<Category> updateCategoryById(int id) {
			return catRepo.findById(id);
	}

	
	//Product Section
	@Autowired
	private ProductRepository prodRepo;

	@Override
	public List<Products> getAllProducts() {
		return prodRepo.findAll();
	}
	@Override
	public void addProduct(Products prod) {
		prodRepo.save(prod);
		
	}
	@Override
	public void deleteProductById(long id) {
		prodRepo.deleteById(id);
		
	}
	@Override
	public Optional<Products> updateProductById(long id) {
		
		return prodRepo.findById(id);
	}
	@Override
	public List<Products> getAllProductsByCategoryId(int id) {
		
		return prodRepo.findAllByCategory_Id(id);
	}

}

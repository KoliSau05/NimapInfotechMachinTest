package com.example.NimapInfotechMTest.service;

import java.util.List;
import java.util.Optional;

import com.example.NimapInfotechMTest.entity.Category;

public interface CategoryServiceInerface {

	public void addCategory(Category cat);
	public List<Category> getAllCategory();
	public void deleteCategoryById(int id);
	public Optional<Category> updateCategoryById(int id);
	
}


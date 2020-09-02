package com.muet.sw.pos.services;

import java.util.List;

import com.muet.sw.pos.models.Category;

public interface CategoryService {
	
	public Category save(Category category);
	public void delete(Integer id);
	public List<Category> findAll();
	public Category update(Category category);
	public Category getCategoryById(Integer id);
}

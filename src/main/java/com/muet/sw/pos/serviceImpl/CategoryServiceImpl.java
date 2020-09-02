package com.muet.sw.pos.serviceImpl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.muet.sw.pos.exceptions.ResourceNotFoundException;
import com.muet.sw.pos.models.Category;
import com.muet.sw.pos.repository.CategoryRepository;
import com.muet.sw.pos.services.CategoryService;

@Service
public class CategoryServiceImpl implements CategoryService {
	
	@Autowired
	private CategoryRepository categoryRepository;
	
	@Override
	public List<Category> findAll() {
		return categoryRepository.findAll();
	}

	@Override
	public Category save(Category category) {
		return categoryRepository.save(category);
	}

	@Override
	public void delete(Integer id) {
		categoryRepository.deleteById(id);
	}

	@Override
	public Category update(Category category) {
		Category c = categoryRepository.getOne(category.getCategoryId());
		c.setCategoryName(category.getCategoryName());
		c.setDescription(category.getDescription());
		return categoryRepository.save(c);
	}

	@Override
	public Category getCategoryById(Integer id) {
		return categoryRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("Category [Cateogry="+id+" ] can't be found"));
	}

}

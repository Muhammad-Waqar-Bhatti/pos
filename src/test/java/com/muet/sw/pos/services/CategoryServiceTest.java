package com.muet.sw.pos.services;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertFalse;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import com.muet.sw.pos.models.Category;
import com.muet.sw.pos.repository.CategoryRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CategoryServiceTest {

	@Autowired
	private CategoryService categoryService;
	
	@MockBean
	private CategoryRepository categoryRepository;
	
	@Test
	public void testSave() {
		Category category = new Category();
		category.setCategoryId(1);
		category.setCategoryName("test");
		category.setDescription("test");
		Mockito.when(categoryRepository.save(category)).thenReturn(category);
		assertThat(categoryService.save(category)).isEqualTo(category);
	}
	
	@Test
	public void testDelete() {
		Category category = new Category();
		category.setCategoryId(1);
		category.setCategoryName("test");
		category.setDescription("test");
		Mockito.when(categoryRepository.getOne(1)).thenReturn(category);
		Mockito.when(categoryRepository.existsById(category.getCategoryId())).thenReturn(false);
		assertFalse(categoryRepository.existsById(category.getCategoryId()));
	}
	
	@Test
	public void testFindAll() {
		Category category = new Category();
		category.setCategoryId(1);
		category.setCategoryName("test");
		category.setDescription("test");
		Category category2 = new Category();
		category2.setCategoryId(2);
		category2.setCategoryName("test2");
		category2.setDescription("test2");
		List<Category> categories = new ArrayList<>();
		categories.add(category);
		categories.add(category2);
		
		Mockito.when(categoryService.findAll()).thenReturn(categories);
		assertThat(categoryService.findAll()).isEqualTo(categories);
	}
	
	@Test
	public void testUpdate() {
		Category category = new Category();
		category.setCategoryId(1);
		category.setCategoryName("test");
		category.setDescription("test");
		Mockito.when(categoryRepository.getOne(1)).thenReturn(category);
		category.setCategoryName("testUpdate");
		Mockito.when(categoryRepository.save(category)).thenReturn(category);
		assertThat(categoryService.update(category)).isEqualTo(category);
	}
}

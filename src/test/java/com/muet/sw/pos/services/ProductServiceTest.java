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
import com.muet.sw.pos.models.Product;
import com.muet.sw.pos.repository.ProductRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductServiceTest {
	@Autowired
	private ProductService service;
	
	@MockBean
	private ProductRepository productRepository;
	
	@Test
	public void testSave() {
		Product p = new Product();
		p.setProductId(1);
		p.setBarcode("test");
		p.setPrice(10.0);
		p.setQuantity(10);
		p.setSize(10);
		Category category = new Category();
		category.setCategoryId(1);
		category.setCategoryName("test");
		category.setDescription("test");
		p.setCategory(category);
		Mockito.when(productRepository.save(p)).thenReturn(p);
		assertThat(service.save(p)).isEqualTo(p);
	}
	
	@Test
	public void testDelete() {
		Product p = new Product();
		p.setProductId(1);
		p.setBarcode("test");
		p.setPrice(10.0);
		p.setQuantity(10);
		p.setSize(10);
		Category category = new Category();
		category.setCategoryId(1);
		category.setCategoryName("test");
		category.setDescription("test");
		p.setCategory(category);
		Mockito.when(productRepository.getOne(1)).thenReturn(p);
		Mockito.when(productRepository.existsById(p.getProductId())).thenReturn(false);
		assertFalse(productRepository.existsById(p.getProductId()));
	}
	
	@Test
	public void testFindAll() {
		Product p = new Product();
		p.setProductId(1);
		p.setBarcode("test");
		p.setPrice(10.0);
		p.setQuantity(10);
		p.setSize(10);
		Category category = new Category();
		category.setCategoryId(1);
		category.setCategoryName("test");
		category.setDescription("test");
		p.setCategory(category);
		Product p2 = new Product();
		p2.setProductId(2);
		p2.setBarcode("test2");
		p2.setPrice(10.0);
		p2.setQuantity(10);
		p2.setSize(10);
		Category category2 = new Category();
		category2.setCategoryId(2);
		category2.setCategoryName("test2");
		category2.setDescription("test2");
		p2.setCategory(category2);
		List<Product> products = new ArrayList<>();
		products.add(p);
		products.add(p2);
		
		Mockito.when(productRepository.findAll()).thenReturn(products);
		assertThat(service.findAll()).isEqualTo(products);
	}
	
	@Test
	public void testUpdate() {
		Product p = new Product();
		p.setProductId(1);
		p.setBarcode("test");
		p.setPrice(10.0);
		p.setQuantity(10);
		p.setSize(10);
		Category category = new Category();
		category.setCategoryId(1);
		category.setCategoryName("test");
		category.setDescription("test");
		p.setCategory(category);
		Mockito.when(productRepository.getOne(1)).thenReturn(p);
		p.setProductName("testUpdate");
		Mockito.when(productRepository.save(p)).thenReturn(p);
		assertThat(service.update(p)).isEqualTo(p);
	}
}

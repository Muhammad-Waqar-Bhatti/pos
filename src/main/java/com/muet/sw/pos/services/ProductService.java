package com.muet.sw.pos.services;

import java.util.List;

import com.muet.sw.pos.models.Product;

public interface ProductService {
	public Product save(Product product);
	public void delete(Integer id);
	public List<Product> findAll();
	public Product update(Product product);
}

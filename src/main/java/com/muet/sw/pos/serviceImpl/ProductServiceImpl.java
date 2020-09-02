package com.muet.sw.pos.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.muet.sw.pos.models.Product;
import com.muet.sw.pos.repository.ProductRepository;
import com.muet.sw.pos.services.ProductService;

@Service
public class ProductServiceImpl implements ProductService{
	
	@Autowired
	private ProductRepository productRepository;
	
	@Override
	public Product save(Product product) {
		return productRepository.save(product);
	}

	@Override
	public void delete(Integer id) {
		productRepository.deleteById(id);
	}

	@Override
	public List<Product> findAll() {
		return productRepository.findAll();
	}

	@Override
	public Product update(Product product) {
		Product p = productRepository.getOne(product.getProductId());
		p.setProductName(product.getProductName());
		p.setBarcode(product.getBarcode());
		p.setCategory(product.getCategory());
		p.setPrice(product.getPrice());
		p.setQuantity(product.getQuantity());
		p.setSize(product.getSize());
		return productRepository.save(p);
	}

}

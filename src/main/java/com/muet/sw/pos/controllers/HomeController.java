package com.muet.sw.pos.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.muet.sw.pos.models.Category;
import com.muet.sw.pos.models.Product;
import com.muet.sw.pos.services.CategoryService;
import com.muet.sw.pos.services.ProductService;

@Controller
public class HomeController {
	
	@Autowired
	private CategoryService categoryService;
	
	@Autowired
	private ProductService productService;

	@GetMapping("/")
	public String login() {
		return "home";
	}
	
	@GetMapping("/categories")
	public String categories(Model model) {
		List<Category> categories = categoryService.findAll();
		model.addAttribute("categories", categories);
		return "categories";
	}
	
	@GetMapping("/categories/delete/{id}")
	public String deleteCategories(@PathVariable(name = "id") Integer id) {
		categoryService.delete(id);
		return "redirect:/categories";
	}
	
	@PostMapping("/categories/save")
	public String saveCategory(@RequestParam("categoryName") String categoryName, @RequestParam("description") String description) {
		
		Category category = new Category();
		category.setCategoryName(categoryName);
		category.setDescription(description);
		categoryService.save(category);
		return "redirect:/categories";
	}
	
	@PostMapping("/categories/update")
	public String updateCategory(@RequestParam("categoryId") Integer id, @RequestParam("categoryName") String categoryName, @RequestParam("description") String description) {
		Category c = new Category();
		c.setCategoryId(id);
		c.setCategoryName(categoryName);
		c.setDescription(description);
		categoryService.update(c);
		return "redirect:/categories";
	}
	
	@GetMapping("/products")
	public String products(Model model) {
		List<Product> products = productService.findAll();
		List<Category> categories = categoryService.findAll();
		model.addAttribute("products", products);
		model.addAttribute("categories", categories);
		System.out.println(categories.get(0).getCategoryName());
		
		return "products";
	}
	
	@GetMapping("/products/delete/{id}")
	public String deleteProducts(@PathVariable(name = "id") Integer id) {
		productService.delete(id);
		return "redirect:/products";
	}
	
	@PostMapping("/products/save")
	public String saveProduct(@RequestParam("productName") String productName, @RequestParam("category") Integer categoryId, @RequestParam("barcode") String barcode, @RequestParam("price") Double price, @RequestParam("size") Integer size, @RequestParam("quantity") Integer quantity) {
		Product product = new Product();
		product.setProductName(productName);
		product.setCategory(categoryService.getCategoryById(categoryId));
		product.setBarcode(barcode);
		product.setPrice(price);
		product.setSize(size);
		product.setQuantity(quantity);
		productService.save(product);
		return "redirect:/products";
	}
	
	@PostMapping("/products/update")
	public String updateProduct(@RequestParam("productId") Integer productId,@RequestParam("productName") String productName, @RequestParam("category") Integer categoryId, @RequestParam("barcode") String barcode, @RequestParam("price") Double price, @RequestParam("size") Integer size, @RequestParam("quantity") Integer quantity) {
		Product product = new Product();
		product.setProductId(productId);
		product.setProductName(productName);
		product.setCategory(categoryService.getCategoryById(categoryId));
		product.setBarcode(barcode);
		product.setPrice(price);
		product.setSize(size);
		product.setQuantity(quantity);
		productService.update(product);
		return "redirect:/products";
	}
	
}

package com.teressas.candyshop.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.teressas.candyshop.models.Product;
import com.teressas.candyshop.repositories.ProductRepository;

@Service
public class ProductService {
	
	@Autowired
	ProductRepository productRepo;
	
	// Add or edit a product
	public Product saveProduct(Product product) {
		return productRepo.save(product);
	}
	
	// Find all products
	public List<Product> allProducts() {
		return productRepo.findAll();
	}
	
	// Find one product
	public Product findProductById(Long id) {
		Optional<Product> optionalProduct = productRepo.findById(id);
		if(optionalProduct.isPresent()) {
			return optionalProduct.get();
		} else {
			return null;
		}
	}
	
	// Add category to product
	public Product addCategoryToProduct(Product product) {
		return productRepo.save(product);
	}
	
	// Get product by category
//	public List<Product> getAllProductsByCategoryId(Long id){
//		return productRepo.findAllByCategory_Id(id);
//	}
	
	// Delete product
	public void removeProductById(Long id) {
		productRepo.deleteById(id);
	}
}

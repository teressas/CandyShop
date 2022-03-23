package com.teressas.candyshop.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.teressas.candyshop.models.Category;
import com.teressas.candyshop.models.Product;
import com.teressas.candyshop.repositories.CategoryRepository;
import com.teressas.candyshop.repositories.ProductRepository;

@Service
public class CategoryService {

	@Autowired
	CategoryRepository categoryRepo;
	
	@Autowired
	ProductRepository productRepo;

	// Add or Edit a category
	public Category saveCategory(Category category) {
		return categoryRepo.save(category);
	}

	// Find all categories
	public List<Category> allCategories() {
		return categoryRepo.findAll();
	}

	// Find one category
	public Category findCategoryById(Long categoryId) {
		Optional<Category> optionalCategory = categoryRepo.findById(categoryId);
		if (optionalCategory.isPresent()) {
			return optionalCategory.get();
		} else {
			return null;
		}
	}
	

	// get Category by Id
//	public Optional<Category> getCategoryById(Long id) {
//		return categoryRepo.findById(id);
//	}
	
	// add product to category id
	public List<Product> getAllProductsByCategoryId(Long categoryId){
	    
	    // retrieve an instance of a category using another method in the service.
	    Category thisCategory = findCategoryById(categoryId);
	    
	    // retrieve an instance of a product using another method in the service.
//	    Optional<Product> thisProduct = productRepo.findById(productId);
	    
	    
	    // add the product to this category's list of products
	    return thisCategory.getProducts();
	   
	    
	    // Save thisCategory, since you made changes to its product list.
//	    categoryRepo.save(thisCategory);	


	}


	// Find a list of all categories for a specific product
//	public List<Category> findCategoriesByProduct(Product product) {
//		return categoryRepo.findAllByProducts(product);
//	}
//	
	// Delete a Category
	public void deleteCategoryById(Long id) {
		categoryRepo.deleteById(id);
	}
}

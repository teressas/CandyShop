package com.teressas.candyshop.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.teressas.candyshop.models.Category;
import com.teressas.candyshop.models.Product;
import com.teressas.candyshop.repositories.CategoryRepository;

@Service
public class CategoryService {

	@Autowired
	CategoryRepository categoryRepo;

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

	// Find a list of all categories for a specific product
	public List<Category> findCategoriesByProduct(Product product) {
		return categoryRepo.findAllByProducts(product);
	}
	
	// Delete a Category
	public void deleteCategoryById(Long id) {
		categoryRepo.deleteById(id);
	}
}

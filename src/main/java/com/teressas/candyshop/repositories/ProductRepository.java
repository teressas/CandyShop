package com.teressas.candyshop.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.teressas.candyshop.models.Category;
import com.teressas.candyshop.models.Product;


@Repository
public interface ProductRepository extends JpaRepository<Product, Long>{
	
	List<Product> findAll();
	
	List<Product> findAllByCategories(Category category);
	
	List<Product> findByCategoriesNotContains(Product product);
	
	List<Product> findByCategoriesContains(Product product);

}
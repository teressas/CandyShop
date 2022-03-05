package com.teressas.candyshop.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.teressas.candyshop.models.Category;
import com.teressas.candyshop.models.Product;


@Repository
public interface CategoryRepository extends JpaRepository<Category, Long>{
	
	List<Category> findAll();
	
	List<Category> findAllByProducts(Product product);	
	
	
	
}

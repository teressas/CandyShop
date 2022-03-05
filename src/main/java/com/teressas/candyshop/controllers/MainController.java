package com.teressas.candyshop.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.teressas.candyshop.models.Category;
import com.teressas.candyshop.models.Product;
import com.teressas.candyshop.services.CategoryService;
import com.teressas.candyshop.services.ProductService;


@Controller
public class MainController {
	
	@Autowired
	ProductService prodService;
	
	@Autowired
	CategoryService catService;	
	
	@GetMapping({"/", "/home"})
	public String home(Model model) {
		return "index";
	}
	
	@GetMapping("/shop")
	public String shop(Model model) {
		List<Category> categories = catService.allCategories();
		model.addAttribute("categories", categories);
		List<Product> products = prodService.allProducts();
		model.addAttribute("products", products);
		return "shop";
	}
	
	
	
}
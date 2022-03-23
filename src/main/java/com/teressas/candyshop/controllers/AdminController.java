package com.teressas.candyshop.controllers;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.teressas.candyshop.models.Category;
import com.teressas.candyshop.models.Product;
import com.teressas.candyshop.services.CategoryService;
import com.teressas.candyshop.services.ProductService;

@Controller
public class AdminController {
	
		// Java.lang.System class - for uploading files from local directory
		public static String uploadDir = System.getProperty("user.dir") + "/src/main/resources/static/productImages/";

		@Autowired
		CategoryService catService;

		@Autowired
		ProductService prodService;

		// Show admin dashboard
		@GetMapping("/admin")
		public String adminHome() {
			return "adminHome";
		}

		// show all categories
		@GetMapping("/admin/categories")
		public String manageCategories(Model model) {
			List<Category> categories = catService.allCategories();
			model.addAttribute("categories", categories);
			return "categories";
		}

		// show add new Category Form
		@GetMapping("/admin/categories/add")
		public String newCategoryForm(@ModelAttribute("newCategory") Category newCategory) {
			return "newCategoryForm";
		}

		// process create new Category Form
		@PostMapping("/admin/categories/add")
		public String createNewCategory(@Valid @ModelAttribute("newCategory") Category newCategory, BindingResult result) {
			if (result.hasErrors()) {
				return "newCategoryForm";
			} else {
				catService.saveCategory(newCategory);
				return "redirect:/admin/categories";
			}
		}

		// show edit Category Form
		@GetMapping("/admin/categories/edit/{id}")
		public String editCategoryForm(@PathVariable("id") Long id, Model model) {
			Category category = catService.findCategoryById(id);
			model.addAttribute("category", category);
			return "editCategoryForm";
		}

		// process edit Category Form
		@PutMapping("/admin/categories/edit/{id}")
		public String updateCategory(@Valid @ModelAttribute("category") Category category, BindingResult result,
				@PathVariable("id") Long id) {
			if (result.hasErrors()) {
				return "editCategoryForm";
			} else {
				catService.saveCategory(category);
				return "redirect:/admin/categories";
			}
		}

		// delete category
		@GetMapping("/admin/categories/delete/{id}")
		public String deleteCategory(@PathVariable Long id) {
			catService.deleteCategoryById(id);
			return "redirect:/admin/categories";
		}

		// PRODUCTS
		// show all products
		@GetMapping("/admin/products")
		public String manageProducts(Model model) {
			List<Product> products = prodService.allProducts();
			model.addAttribute("products", products);
			return "products";
		}

		// show add new product form
		@GetMapping("/admin/products/add")
		public String newProductForm(@ModelAttribute("newProduct") Product newProduct, Model model) {
			List<Category> categories = catService.allCategories();
			model.addAttribute("categories", categories);
			return "newProductForm";
		}

		// process create new Product
		@PostMapping("/admin/products/add")
		public String createNewProduct(@Valid @ModelAttribute("newProduct") Product newProduct, BindingResult result,
				Model model, 
				@RequestParam("productImage") MultipartFile file, @RequestParam("imgName") String imgName)
				throws IOException {
			// set variable for image unique id
			String imageUUID;
			// if form has errors, return user to form
			if (result.hasErrors()) {
				List<Category> categories = catService.allCategories();
				model.addAttribute("categories", categories);
				return "newProductForm";
			} else {
				// show all categories
				List<Category> categories = catService.allCategories();
				model.addAttribute("categories", categories);
				// if file input 
				if (!file.isEmpty()) {
					imageUUID = file.getOriginalFilename();
					Path fileNameAndPath = Paths.get(uploadDir, imageUUID);
					Files.write(fileNameAndPath, file.getBytes());
				} else {
					imageUUID = imgName;
				}
				
				newProduct.setImageName(imageUUID);
				prodService.saveProduct(newProduct);
			
				return "redirect:/admin/products";
			}
		}

		// show edit product form
		@GetMapping("/admin/products/edit/{id}")
		public String showEditProductForm(@PathVariable Long id, Model model) {
			Product product = prodService.findProductById(id);
			List<Category> categories = catService.allCategories();
			model.addAttribute("categories", categories);
			model.addAttribute("newProduct", product);
			return "newProductForm";
		}

		// delete product
		@GetMapping("/admin/products/delete/{id}")
		public String deleteProduct(@PathVariable Long id) {
			prodService.removeProductById(id);
			return "redirect:/admin/products";
		}

}

//package com.teressas.candyshop.models;
//
//import java.util.Date;
//import java.util.List;
//
//import javax.persistence.Column;
//import javax.persistence.Entity;
//import javax.persistence.FetchType;
//import javax.persistence.GeneratedValue;
//import javax.persistence.GenerationType;
//import javax.persistence.Id;
//import javax.persistence.JoinColumn;
//import javax.persistence.ManyToOne;
//import javax.persistence.PrePersist;
//import javax.persistence.PreUpdate;
//import javax.persistence.Table;
//
//@Entity
//@Table(name="categories_products")
//public class CategoryProduct {
//	
//	@Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Long id;
//	
//    @Column(updatable=false)
//    private Date createdAt;
//    private Date updatedAt;
//    @ManyToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name="product_id")
//    private Product product;
//    
//    private Long product_id;
//    
//    private List<Product> products;
//    
//    @ManyToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name="category_id")
//    private Category category;
//    
//    private Long category_id;
//    
//    
//    public CategoryProduct() {
//        
//    }
//    
//   	public CategoryProduct(Product product, Long product_id, List<Product> products, Category category, Long category_id,
//			) {
//		this.product = product;
//		this.product_id = product_id;
//		this.products = products;
//		this.category = category;
//		this.category_id = category_id;
////		this.categories = categories;
//	}
//
//
//	public Long getId() {
//		return id;
//	}
//
//	public void setId(Long id) {
//		this.id = id;
//	}
//
//	public Date getCreatedAt() {
//		return createdAt;
//	}
//
//	public void setCreatedAt(Date createdAt) {
//		this.createdAt = createdAt;
//	}
//
//	public Date getUpdatedAt() {
//		return updatedAt;
//	}
//
//	public void setUpdatedAt(Date updatedAt) {
//		this.updatedAt = updatedAt;
//	}
//
//	public Product getProduct() {
//		return product;
//	}
//
//	public void setProduct(Product product) {
//		this.product = product;
//	}
//
//	public Long getProduct_id() {
//		return product_id;
//	}
//
//	public void setProductId(Long productId) {
//		this.product_id = product_id;
//	}
//
//	public List<Product> getProducts() {
//		return products;
//	}
//
//	public void setProducts(List<Product> products) {
//		this.products = products;
//	}
//
//	public Category getCategory() {
//		return category;
//	}
//
//	public void setCategory(Category category) {
//		this.category = category;
//	}
//
//	public Long getCategoryId() {
//		return category_id;
//	}
//
//	public void setCategoryId(Long categoryId) {
//		this.category_id = categoryId;
//	}
//
////	public List<Category> getCategories() {
////		return categories;
////	}
////
////	public void setCategories(List<Category> categories) {
////		this.categories = categories;
////	}
//
//	@PrePersist
//	protected void onCreated() {
//		this.createdAt = new Date();
//	}
//	
//	@PreUpdate
//	protected void onUpdated() {
//		this.updatedAt = new Date();
//	}
//	
//    
//}

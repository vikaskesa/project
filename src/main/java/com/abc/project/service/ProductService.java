package com.abc.project.service;

import java.util.List;

import com.abc.project.entity.Product;

public interface ProductService {
	public Product saveProduct(Product product);
	 
	 public List<Product> getAllProducts();
	 
	 public Product getProductById(int productId);
	 
	 public Product updateProduct(Product product);
	 
	 public void deleteProduct(int productId);

}

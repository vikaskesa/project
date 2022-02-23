package com.abc.project.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.abc.project.entity.Product;
import com.abc.project.exception.ProductNotFoundException;
import com.abc.project.repository.ProductRepository;


@Service
public class ProductServiceImpl implements ProductService{
	@Autowired
	private ProductRepository productRepository;
	
	public Product saveProduct(Product product) {
		return productRepository.save(product);
		
	}

	@Override
	public List<Product> getAllProducts() {
		List<Product> products=productRepository.findAll();
		return products;
	}

	@Override
	public Product getProductById(int productId) {
		
		Optional<Product> optionalProduct=productRepository.findById(productId);
		if(optionalProduct.isEmpty()) {
			throw new ProductNotFoundException("Sorry product is not registered");
			
		}
		return optionalProduct.get();
	}

	@Override
	public Product updateProduct(Product product) {
		Optional<Product> optionalProduct=productRepository.findById(product.getProductId());
		if(optionalProduct.isEmpty()) {
			throw new ProductNotFoundException("Sorry product is not registered");
			
		}
		Product updatedProduct=productRepository.save(product);
		return updatedProduct;
	}

	@Override
	public void deleteProduct(int productId) {
		Optional<Product> optionalProduct=productRepository.findById(productId);
		if(optionalProduct.isPresent()) {
			
			productRepository.deleteById(productId);
			
		}
		else {
			throw new ProductNotFoundException("Sorry product is not registered");
		}
	// TODO Auto-generated method stub
		
	}
	

}

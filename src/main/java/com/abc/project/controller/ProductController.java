package com.abc.project.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.abc.project.entity.Customer;
import com.abc.project.entity.Product;
import com.abc.project.service.ProductService;

import io.swagger.annotations.ApiOperation;



@RestController
@RequestMapping("/product")
public class ProductController {
	@Autowired
	private ProductService productService;
	
	
	@ApiOperation(value = "adding a product", response = Product.class, tags = "add Product")
	@PostMapping("/save")
	public ResponseEntity<Product> addProduct(@RequestBody Product product) {

		Product newProduct = productService.saveProduct(product);
		ResponseEntity<Product> responseEntity = new ResponseEntity<>(newProduct, HttpStatus.CREATED);
		return responseEntity;
	}
	
	
	@ApiOperation(value = "Fetching all the products", response = Product.class, tags = "Fetch Product")
	@GetMapping("/all")
	public List<Product> fetchAllProducts() {
		List<Product> products = productService.getAllProducts();
		return products;
		}
	
	
	@ApiOperation(value = "Fetching product by product id", response = Product.class, tags = "get Product")
	@GetMapping("/get/{pid}")
	public  ResponseEntity<Product> fetchProductDetails(@PathVariable("pid") int productId) {
		Product product = productService.getProductById(productId);
		return new ResponseEntity<>(product, HttpStatus.OK);
	}
	
	
	@ApiOperation(value = "deleting the product by product id", response = Product.class, tags = "delete product")
	@DeleteMapping("/delete/{pid}")
	public ResponseEntity<?> deleteProduct(@PathVariable("pid") int productId) {
		productService.deleteProduct(productId);
		return new ResponseEntity<>("Product Deleted with id :" + productId, HttpStatus.OK);

	}

	@ApiOperation(value = "Modifying the product", response = Product.class, tags = "modify product")
	@PutMapping("/update")
	public ResponseEntity<Product> modifyProduct(@RequestBody Product product) {
		Product updatedProduct = productService.updateProduct(product);
		return new ResponseEntity<>(updatedProduct, HttpStatus.OK);
	}

}

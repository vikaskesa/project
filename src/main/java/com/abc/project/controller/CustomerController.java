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
import com.abc.project.service.CustomerService;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/customer")
public class CustomerController {
	
		
		@Autowired
		private CustomerService customerService;
		@ApiOperation(value = "Adding the costumers", response = Customer.class, tags = "Add Customer")
		@PostMapping("/save")
		public ResponseEntity<Customer> addCustomer(@RequestBody Customer customer) {

			Customer newCustomer = customerService.saveCustomer(customer);
			ResponseEntity<Customer> responseEntity = new ResponseEntity<>(newCustomer, HttpStatus.CREATED);
			return responseEntity;
		}
		@ApiOperation(value = "Fetching all the customers", response = Customer.class, tags = "fetch Customer")
		@GetMapping("/all")
		public List<Customer> fetchAllCustomers() {
			List<Customer> customers = customerService.getAllCustomers();
			return customers;
		}
		
		
		@ApiOperation(value = "Get specific Customer by customerId", response = Customer.class, tags = "get Customer")
		@GetMapping("/get/{cid}")
		public ResponseEntity<Customer>fetchCustomerDetails(@PathVariable("cid") int customerId) {
			Customer customer = customerService.getCustomerById(customerId);
			return new ResponseEntity<>(customer, HttpStatus.OK);
		}
		
		
		@ApiOperation(value = "Deleting Customer by customerId", response = Customer.class, tags = "Delete Customer")
		@DeleteMapping("/delete/{cid}")
		public ResponseEntity<?> deleteCustomer(@PathVariable("cid") int customerId) {
			customerService.deleteCustomer(customerId);
			return new ResponseEntity<>("Product Deleted with id :" + customerId, HttpStatus.OK);

		}
		
		
		@ApiOperation(value = "Modifying Customer", response = Customer.class, tags = "modify Customer")
		@PutMapping("/update")
		public ResponseEntity<Customer> modifyProduct(@RequestBody Customer customer) {
			Customer updatedCustomer = customerService.updateCustomer(customer);
			return new ResponseEntity<>(updatedCustomer, HttpStatus.OK);
		}

	}

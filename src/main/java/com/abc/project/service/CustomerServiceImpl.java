package com.abc.project.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.abc.project.entity.Customer;
import com.abc.project.exception.CustomerNotFoundException;
import com.abc.project.repository.CustomerRepository;

import io.swagger.annotations.ApiOperation;

@Service

public class CustomerServiceImpl  implements CustomerService{
		@Autowired
		private CustomerRepository customerRepository;
	@Override
	public Customer saveCustomer(Customer customer) {
		return customerRepository.save(customer);
	}

	@Override
	public List<Customer> getAllCustomers() {
		List<Customer> customers=customerRepository.findAll();
		return customers;
	}

	@Override
	public Customer getCustomerById(int customerId) {
		Optional<Customer> optionalProduct=customerRepository.findById(customerId);
		if(optionalProduct.isEmpty()) {
			throw new CustomerNotFoundException("Sorry Customer is not registered");
			
		}
		return optionalProduct.get();
	}


	@Override
	public Customer updateCustomer(Customer customer) {
		Optional<Customer> optionalProduct=customerRepository.findById(customer.getCustomerId());
		if(optionalProduct.isEmpty()) {
			throw new CustomerNotFoundException("Sorry Customer is not registered");
			
		}
		Customer updatedProduct=customerRepository.save(customer);
		return updatedProduct;
	}

	@Override
	public void deleteCustomer(int customerId) {
		Optional<Customer> optionalCustomer = customerRepository.findById(customerId);
		if (optionalCustomer.isPresent()) {
			customerRepository.deleteById(customerId);
		} else {
			throw new CustomerNotFoundException("sorry customer is not existing with id:" + customerId);
		}
	}
}
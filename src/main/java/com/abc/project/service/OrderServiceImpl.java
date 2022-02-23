package com.abc.project.service;

import java.time.LocalDate;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.abc.project.entity.Order;
import com.abc.project.entity.Product;
import com.abc.project.exception.ProductNotFoundException;
import com.abc.project.exception.ResourceNotFoundException;
import com.abc.project.repository.OrderRepository;
import com.abc.project.repository.ProductRepository;
@Service
public class OrderServiceImpl implements OrderService {

	@Autowired
	private OrderRepository orderRepository;
	
	@Autowired
	private ProductRepository productRepository;

	@Override
	public Order saveOrder(Order order) {
		
		order.setOrderDate(LocalDate.now());
		
		// calculate Order amount
		
		int productId = order.getProductId();
		
		Optional<Product> optionalProduct = productRepository.findById(productId);
		
		if(optionalProduct.isEmpty()) {
			throw new ProductNotFoundException("Product not exising with id: "+productId);
		}
		else {
			Product product = optionalProduct.get();
			int unitPrice = product.getProductPrice();
			int  orderAmount = order.getQuantity() * unitPrice;
			
			order.setOrderAmmount(orderAmount);
		}		
		
		Order newOrder = orderRepository.save(order);
		return newOrder;
	}

	@Override
	public Order getOrderDetails(int orderId) {
	
		Optional<Order> optionalOrder = orderRepository.findById(orderId);
		if(optionalOrder.isEmpty()) {
			throw new ResourceNotFoundException("Order not found with Order Id: "+orderId);
		}
		
		return optionalOrder.get();
	}

	

}

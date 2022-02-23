package com.abc.project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.abc.project.entity.Customer;
import com.abc.project.entity.Order;
import com.abc.project.service.OrderService;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/order")
public class OrderController {

	@Autowired
	private OrderService orderService;
	@ApiOperation(value = "placing an order", response = Order.class, tags = "placeOrder")
	@PostMapping("/create")
	public ResponseEntity<Order> placeOrder(@RequestBody Order order) {
			
		Order newOrder = orderService.saveOrder(order);
		
		return new ResponseEntity<>(newOrder,HttpStatus.CREATED);
		
	}
}
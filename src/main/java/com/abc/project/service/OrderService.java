package com.abc.project.service;

import com.abc.project.entity.Order;

public interface OrderService {
	public Order saveOrder(Order order);
	
	public Order getOrderDetails(int orderId);
}

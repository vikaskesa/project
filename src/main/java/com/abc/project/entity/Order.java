package com.abc.project.entity;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="order_tbl")
public class Order {
	
	@Id
	@Column(name="order_id")
	private int orderId;
	
	@Column(name="order_date")	
	private LocalDate orderDate;
	
	@Column(name="order_ammount")
	private int orderAmmount;
	
	@Column(name="product_id")
	private int productId;
	
	
	private int quantity;
	
	@Column(name="customer_id")
	private int customerId;

	public int getOrderId() {
		return orderId;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}

	public LocalDate getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(LocalDate orderDate) {
		this.orderDate = orderDate;
	}

	public int getOrderAmmount() {
		return orderAmmount;
	}

	public void setOrderAmmount(int orderAmount) {
		this.orderAmmount = orderAmount;
	}

	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public int getCustomerId() {
		return customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

}

package com.abc.project.exception;

public class ProductNotFoundException extends RuntimeException {
	public ProductNotFoundException(String str) {
		super(str);
	}
}

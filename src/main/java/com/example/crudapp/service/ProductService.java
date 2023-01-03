package com.example.crudapp.service;

import java.util.List;

import com.example.crudapp.model.Order;

public interface ProductService {
	Order createProduct(Order product);

	Order updateProduct(Order product);

	List<Order> getAllProduct();

	Order getProductById(int productId);

	void deleteProduct(int id);
	
}

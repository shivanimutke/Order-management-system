package com.example.crudapp.controller;


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
import org.springframework.web.bind.annotation.RestController;

import com.example.crudapp.model.Order;
import com.example.crudapp.service.ProductService;


@RestController
public class ProductController {

	@Autowired
	private ProductService productService;
	
	@GetMapping("/products")
	public ResponseEntity<List<Order>> getAllProduct(){
		return ResponseEntity.ok().body(productService.getAllProduct());
	}
	
	@GetMapping("/products/{id}")
	public ResponseEntity<Order> getProductById(@PathVariable int id){
		return ResponseEntity.ok().body(productService.getProductById(id));
	}
	
	@PostMapping("/products")
	public ResponseEntity<Order> createProduct(@RequestBody Order product){
		return ResponseEntity.ok().body(this.productService.createProduct(product));
	}
	
	@PutMapping("/products/{id}")
	public ResponseEntity<Order> updateProduct(@PathVariable int id, @RequestBody Order product){
		product.setId(id);
		return ResponseEntity.ok().body(this.productService.updateProduct(product));
	}

	@DeleteMapping("/products/{id}")
	public HttpStatus deleteProduct(@PathVariable int id){
		this.productService.deleteProduct(id);
		return HttpStatus.OK;
	}
	
}

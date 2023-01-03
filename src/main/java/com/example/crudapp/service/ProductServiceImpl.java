package com.example.crudapp.service;



import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.crudapp.exception.ResourceNotFoundException;
import com.example.crudapp.model.Order;
import com.example.crudapp.repository.ProductRepository;




@Service
@Transactional
public class ProductServiceImpl implements ProductService{

	
	@Autowired
	private ProductRepository productRepository;
	
	
	@Override
	public Order createProduct(Order product)
	{   
		if(9<this.productRepository.findAll().size()) 
		{
		  product.setCustType("gold"); 
		  int amount=product.getPrice();
		  int discountedPrice=(amount*(100-10))/100;
		  product.setPrice(discountedPrice);
		}
		if(20<this.productRepository.findAll().size())
		{
			product.setCustType("Platinum"); 
			int amount=product.getPrice();
			int discountedPrice=(amount*(100-20))/100;
			product.setPrice(discountedPrice);
		}
		return productRepository.save(product);
	}

	@Override
	public Order updateProduct(Order product) 
	{
		Optional<Order> productDb = this.productRepository.findById(product.getId());
		if(productDb.isPresent()) 
		{
			Order productUpdate = productDb.get();
			productUpdate.setId(product.getId());
			productUpdate.setName(product.getName());
			productUpdate.setDescription(product.getDescription());
			if(9<this.productRepository.findAll().size()) 
			{
			  productUpdate.setCustType("gold"); 
			  int amount=product.getPrice();
			  int discountedPrice=(amount*10)/100;
			  productUpdate.setPrice(discountedPrice);
			}
			if(20<this.productRepository.findAll().size())
			{
				productUpdate.setCustType("Platinum"); 
				int amount=product.getPrice();
				int discountedPrice=(amount*20)/100;
				productUpdate.setPrice(discountedPrice);
			}
			productRepository.save(productUpdate);
			return productUpdate;
		}
		else 
		{
			throw new ResourceNotFoundException("Record not found with id : " + product.getId());
		}		
	}

	@Override
	public  List<Order> getAllProduct() {
		System.out.println("you are promoted to gold customer");
		 if(8<this.productRepository.findAll().size()) {
			 System.out.println("make 2 mor orders to get promoted to our gold customer");
		 }else if(18<this.productRepository.findAll().size()) {
			 System.out.println("you are promoted to platinum customer");
		 }else{
			 System.out.println("you are regular customer , if can get 10% discount if promoted as gold customer for tthat kindly make 10 orders and if u make orders more that 20 u get promoted as platinum customer and can get 20% discount on each order");
		 }
		return productRepository.findAll();
	}

	@Override
	public Order getProductById(int productId) {
		
		Optional<Order> productDb = this.productRepository.findById(productId);
		
		if(productDb.isPresent()) {
			return productDb.get();
		}else {
			throw new ResourceNotFoundException("Record not found with id : " + productId);
		}
	}

	@Override
	public void deleteProduct(int productId) {
		Optional<Order> productDb = this.productRepository.findById(productId);		
		if(productDb.isPresent()) {
			this.productRepository.delete(productDb.get());
		}else {
			throw new ResourceNotFoundException("Record not found with id : " + productId);
		}
		
	}
	


}


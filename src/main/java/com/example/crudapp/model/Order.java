package com.example.crudapp.model;


import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;

@Entity
@Table(name = "Product")
public class Order {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	@Column(name = "name")
	private String name;
	
	@Column(name = "description")
	private String description;
	
	@Column(name = "price")
	private int price;
	
	@CreationTimestamp
	private Date createdAt;
	
	@CreationTimestamp
	private Date updatedAt;
	
	@Column(name = "CustomerType")
	private String custType="Regular";
	
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public Date getCreatedAt() {
		return createdAt;
	}
	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}
	public Date getUpdatedAt() {
		return updatedAt;
	}
	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCustType() {
		return custType;
	}
	public void setCustType(String regcust) {
		this.custType = regcust;
	}
	@Override
	public String toString() {
		return "Order [id=" + id + ", name=" + name + ", description=" + description + ", price=" + price
				+ ", createdAt=" + createdAt + ", updatedAt=" + updatedAt + ", custType=" + custType + "]";
	}
}

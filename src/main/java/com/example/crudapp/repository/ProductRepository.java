package com.example.crudapp.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import com.example.crudapp.model.Order;



public interface ProductRepository extends JpaRepository<Order,Integer> {

}

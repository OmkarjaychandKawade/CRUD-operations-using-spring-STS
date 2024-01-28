package com.example.demo.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.bean.Product;

public interface ProductDao extends JpaRepository<Product, Integer> {

}

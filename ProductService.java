package com.example.demo.service;

import java.util.List;

import com.example.demo.bean.Product;

public interface ProductService {
	void addNewProduct(Product product);
	
	
	 List<Product> getAllProduct() ;
		// TODO Auto-generated method stub
		
	
	void deletedById(int pid);
	
	Product getById(int pid);
	
	int updateProduct(Product product);
	}

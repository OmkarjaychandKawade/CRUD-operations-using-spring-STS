 package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.bean.Product;
import com.example.demo.dao.ProductDao;

@Service
public class ProductServiceimpl implements ProductService{
	
	@Autowired
	ProductDao productDao;
	
	public ProductServiceimpl() {
		
		  
	}
	@Override
	public void addNewProduct(Product product) {
		productDao.save(product);
	}
	@Override
	public List<Product> getAllProduct(){
		return productDao.findAll();
	}
	@Override
	public void deletedById(int pid) {
		// TODO Auto-generated method stub
		productDao.deleteById(pid);
	}
	@Override
	public Product getById(int pid) {
		// TODO Auto-generated method stub
		Optional<Product>op=productDao.findById(pid);
		return op.orElse(null);
	}
	@Override
	public int updateProduct(Product product) {
		// TODO Auto-generated method stub
		Optional<Product>op=productDao.findById(product.getPid());
		if(op.isPresent()) {
			Product p=op.get();
			p.setPname(product.getPname());
			p.setQty(product.getQty());
			p.setPrice(product.getPrice());
			productDao.save(p);
			return 1;
			
		}
		return 0;
		
		
		
	}

}
package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.bean.Product;
import com.example.demo.service.ProductService;

@CrossOrigin(origins = "*")//it apply all the request mapping object
@RestController
@RequestMapping("/product")
public class ProductController {

	@RequestMapping("/") 
	public void displayProductController() {
		System.out.println("This is displayproduct Controller");

	}

	@Autowired
	ProductService productService;

	@PostMapping("/products")//when we need to add then we use @post
	public ResponseEntity<String> addProductDetails(@ModelAttribute Product p) {
		productService.addNewProduct(p);
		return new ResponseEntity("Data added Succesfully" + p.getPid(), HttpStatus.CREATED);

	}

	@GetMapping("/all")
	public ResponseEntity<List<Product>> displayAll() {
		List<Product> plist = productService.getAllProduct();
		return ResponseEntity.ok(plist);
		
	
	}

	@PutMapping("/updateProduct")
	public ResponseEntity<String> updateProduct(@ModelAttribute Product p) {
		int n = productService.updateProduct(p);
		if (n > 0)
			return new ResponseEntity("Data added Sucessfully" + p.getPid(), HttpStatus.CREATED);
		else
			return new ResponseEntity(HttpStatus.BAD_REQUEST);
	}

	@DeleteMapping("/product/{pid}")
	public ResponseEntity<String> deleteProduct(@PathVariable int pid) {
		return new ResponseEntity("Data Deleted Sucessfully" + pid, HttpStatus.CREATED);

	}

	@GetMapping("/product/{pid}")
	public ResponseEntity<Product> displayById(@PathVariable int pid) {
		Product p = productService.getById(pid);
		if (p != null) {
			return new ResponseEntity(p, HttpStatus.OK);
		}
		return new ResponseEntity(HttpStatus.NOT_FOUND);
	}

}

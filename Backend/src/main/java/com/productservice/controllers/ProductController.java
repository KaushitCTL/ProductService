package com.productservice.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.productservice.dto.GenericProductDto;
import com.productservice.models.Product;
import com.productservice.services.ProductServices;

@RestController
@RequestMapping("/products")
public class ProductController {
	
	private ProductServices productServices;
	
	public ProductController(@Qualifier("fakeStoreProductService") ProductServices productServices) {
		// TODO Auto-generated constructor stub
		
		this.productServices = productServices;
	}

	@GetMapping("")
	public List<GenericProductDto> getAllProducts() {

		return productServices.getAllProducts();
	}

	@GetMapping("/{id}")
	public GenericProductDto getProductById(@PathVariable("id") Long id) {

		return productServices.getProductById(id);
	}
	
	@PutMapping("/{id}")
	public void updateProductById(@PathVariable("id") Long id) {
		
		
	}
	
	@DeleteMapping("/{id}")
	public void deleteProductById(@PathVariable("id") Long id) {
		
		
	}
	
	@PostMapping
	public void createProduct() {
		
		
	}
}

package com.productservice.services;

import java.util.List;

import com.productservice.dto.GenericProductDto;

public interface ProductServices {

	List<GenericProductDto> getAllProducts();

	GenericProductDto getProductById(Long id);

	void deleteProductById(Long id);

	void createProduct();

	void updateProductById(Long id);
}

package com.productservice.services;

import com.productservice.dto.FakeStoreProductDto;
import com.productservice.models.Product;

public interface ProductServices {

	Product getAllProducts();

	FakeStoreProductDto getProductById(Long id);

	void deleteProductById(Long id);

	void createProduct();

	void updateProductById(Long id);
}

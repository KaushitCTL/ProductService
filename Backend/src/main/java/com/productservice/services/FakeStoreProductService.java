package com.productservice.services;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.productservice.dto.FakeStoreProductDto;
import com.productservice.models.Product;

@Service("fakeStoreProductService")
public class FakeStoreProductService implements ProductServices {

	private RestTemplateBuilder restTemplateBuilder;
	private String url = "https://fakestoreapi.com/products/{id}";
			
	public FakeStoreProductService(RestTemplateBuilder restTemplateBuilder) {
		// TODO Auto-generated constructor stub
		
		this.restTemplateBuilder = restTemplateBuilder;
	}
	
	@Override
	public Product getAllProducts() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public FakeStoreProductDto getProductById(Long id) {
		// TODO Auto-generated method stub
		
		RestTemplate restTemplate = restTemplateBuilder.build();
		ResponseEntity<FakeStoreProductDto> response = 
				restTemplate.getForEntity(url, FakeStoreProductDto.class, id);
		return response.getBody();
	}

	@Override
	public void deleteProductById(Long id) {
		// TODO Auto-generated method stub

	}

	@Override
	public void createProduct() {
		// TODO Auto-generated method stub

	}

	@Override
	public void updateProductById(Long id) {
		// TODO Auto-generated method stub

	}

}

package com.productservice.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.productservice.dto.FakeStoreProductDto;
import com.productservice.dto.GenericProductDto;

@Service("fakeStoreProductService")
public class FakeStoreProductService implements ProductServices {

	private RestTemplateBuilder restTemplateBuilder;
	private String getProductByIdUrl = "https://fakestoreapi.com/products/{id}";	
	private String genericProductUrl = "https://fakestoreapi.com/products";		
	
	public FakeStoreProductService(RestTemplateBuilder restTemplateBuilder) {
		// TODO Auto-generated constructor stub
		
		this.restTemplateBuilder = restTemplateBuilder;
	}
	
	@Override
	public List<GenericProductDto> getAllProducts() {
		// TODO Auto-generated method stub
		RestTemplate restTemplate = restTemplateBuilder.build();
		ResponseEntity<FakeStoreProductDto[]> responseEntity = 
				restTemplate.getForEntity(genericProductUrl, FakeStoreProductDto[].class);
		
		List<FakeStoreProductDto> fakeStoreProductDtos = List.of(responseEntity.getBody());
		List<GenericProductDto> result = new ArrayList<GenericProductDto>();
		
		for(FakeStoreProductDto fakeStoreProductDto: fakeStoreProductDtos) {
			
			result.add(convertToGenericProductDto(fakeStoreProductDto));
		}
		
		return result;
	}

	@Override
	public GenericProductDto getProductById(Long id) {
		// TODO Auto-generated method stub
		
		RestTemplate restTemplate = restTemplateBuilder.build();
		ResponseEntity<FakeStoreProductDto> response = 
				restTemplate.getForEntity(getProductByIdUrl, FakeStoreProductDto.class, id);
		
		FakeStoreProductDto fakeStoreProductDto = response.getBody();
		
		return convertToGenericProductDto(fakeStoreProductDto);
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

	private static GenericProductDto convertToGenericProductDto(FakeStoreProductDto fakeStoreProductDto){
		
		GenericProductDto genericProductDto = new GenericProductDto();
		genericProductDto.setId(fakeStoreProductDto.getId());
		genericProductDto.setTitle(fakeStoreProductDto.getTitle());
		genericProductDto.setPrice(fakeStoreProductDto.getPrice());
		genericProductDto.setDescription(fakeStoreProductDto.getDescription());
		genericProductDto.setCategory(fakeStoreProductDto.getCategory());;
		genericProductDto.setImage(fakeStoreProductDto.getImage());
		
		return genericProductDto;
	}
}

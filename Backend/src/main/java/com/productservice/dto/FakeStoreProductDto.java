package com.productservice.dto;

import com.productservice.models.BaseModel;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class FakeStoreProductDto{

	private Long id;
	private String title;
	private int price;
	private String description;
	private String category;
	private String image;
}

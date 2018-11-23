package com.projects.api.util;

import com.projects.api.model.Category;
import com.projects.api.model.Product;
import com.projects.api.payload.response.ProductResponse;

public class ProductMapper{
	
	public static ProductResponse mapProductToProductResponse(Product product){
		
		ProductResponse productResponse = new ProductResponse();
		
		Category category = product.getCategory();
		
		productResponse.setId(product.getId());
		productResponse.setName(product.getName());
		productResponse.setIntroDate(product.getIntroDate());
		productResponse.setPrice(product.getPrice());
		productResponse.setUrl(product.getUrl());
		productResponse.setCategoryId(category.getId());
		
		return productResponse;
	}

}

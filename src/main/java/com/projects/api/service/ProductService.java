package com.projects.api.service;

import java.util.LinkedList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.projects.api.model.Product;
import com.projects.api.payload.response.PagedResponse;
import com.projects.api.payload.response.ProductResponse;
import com.projects.api.repository.ProductRepository;
import com.projects.api.util.ProductMapper;

@Service
public class ProductService{

	@Autowired
	private ProductRepository productRepository;
	
	public PagedResponse<ProductResponse> getProducts(int page, int size){
		
		Pageable pageable = PageRequest.of(page, size, Sort.Direction.ASC, "name");
		
		Page<Product> products = productRepository.findAll(pageable);
		
		List<ProductResponse> productResponses = new LinkedList<>();
		
		if(products.getNumberOfElements() == 0){
			return new PagedResponse<>(
					productResponses,
					products.getNumber(),
					products.getSize(),
					products.getTotalElements(),
					products.getTotalPages(),
					products.isLast());
		}
		
		productResponses = products.map(product -> {
			return ProductMapper.mapProductToProductResponse(product);
		}).getContent();
		
		return new PagedResponse<>(
				productResponses,
				products.getNumber(),
				products.getSize(),
				products.getTotalElements(),
				products.getTotalPages(),
				products.isLast());
	}
}

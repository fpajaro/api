package com.projects.api.controller;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.projects.api.payload.response.PagedResponse;
import com.projects.api.payload.response.ProductResponse;
import com.projects.api.service.ProductService;
import com.projects.api.util.AppConstants;

@RestController
@RequestMapping("/products")
public class ProductController{
	
	@Autowired
	private ProductService productService;

	@GetMapping
	public PagedResponse<ProductResponse> getProducts(
			@RequestParam(value = "page", defaultValue = AppConstants.DEFAULT_PAGE_NUMBER) int page,
            @RequestParam(value = "size", defaultValue = AppConstants.DEFAULT_PAGE_SIZE) int size){
		
		return productService.getProducts(page, size);
	}
	
	@GetMapping("/test")
	public LocalDate test(){
		
		return LocalDate.now();
	}
}

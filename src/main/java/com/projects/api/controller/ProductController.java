package com.projects.api.controller;

import java.time.LocalDate;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.projects.api.payload.request.ProductRequest;
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
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public ProductResponse createProduct(@Valid @RequestBody ProductRequest productRequest){
		
		return productService.createProduct(productRequest);
	}
	
	@GetMapping("/{productId}")
	public ProductResponse getProduct(@PathVariable long productId){
		
		return productService.getProduct(productId);
	}
	
	@PutMapping("/{productId}")
	public ProductResponse editProduct(
			@PathVariable long productId,
			@Valid @RequestBody ProductRequest productRequest){
		
		return productService.editProduct(productId, productRequest);
	}
	
	@DeleteMapping("/{productId}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void deleteProduct(@PathVariable long productId){
		
		productService.deleteProduct(productId);
	}
	
	@GetMapping("/test")
	public LocalDate test(){
		
		return LocalDate.now();
	}
}

package com.projects.api.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.projects.api.payload.request.CategoryRequest;
import com.projects.api.payload.response.CategoryResponse;
import com.projects.api.service.CategoryService;

@RestController
@RequestMapping("/categories")
public class CategoryController{
	
	@Autowired
	private CategoryService categoryService;
	
	@GetMapping
	public List<CategoryResponse> getCategories(){
		
		return categoryService.getCategories();
	}
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public CategoryResponse createCategory(@Valid @RequestBody CategoryRequest categoryRequest){
		
		return categoryService.createCategory(categoryRequest);
	}
}

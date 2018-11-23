package com.projects.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}

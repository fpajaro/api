package com.projects.api.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projects.api.model.Category;
import com.projects.api.payload.response.CategoryResponse;
import com.projects.api.repository.CategoryRepository;
import com.projects.api.util.CategoryMapper;

@Service
public class CategoryService{

	@Autowired
	private CategoryRepository categoryRepository;
	
	public List<CategoryResponse> getCategories(){
		
		List<Category> results = categoryRepository.findAll();
	
		List<CategoryResponse> categories = results.stream().map(
				cat -> CategoryMapper.mapCategoryToCategoryResponse(cat))
		.collect(Collectors.toList());
		
		return categories;
	}
}

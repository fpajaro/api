package com.projects.api.util;

import com.projects.api.model.Category;
import com.projects.api.payload.response.CategoryResponse;

public class CategoryMapper{

	public static CategoryResponse mapCategoryToCategoryResponse(Category category){
		
		CategoryResponse categoryResponse = new CategoryResponse();
		
		categoryResponse.setId(category.getId());
		categoryResponse.setName(category.getName());
		
		return categoryResponse;
	}
}

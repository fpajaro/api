package com.projects.api.payload.response;

import java.math.BigDecimal;
import java.time.Instant;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class ProductResponse{

	private long id;
	private String name;
	private Instant introDate;
	private BigDecimal price;
	private String url;
	private long categoryId;
	
	public long getId(){
		return id;
	}
	
	public void setId(long id){
		this.id = id;
	}
	
	public String getName(){
		return name;
	}
	
	public void setName(String name){
		this.name = name;
	}
	
	public Instant getIntroDate(){
		return introDate;
	}
	
	public void setIntroDate(Instant introDate){
		this.introDate = introDate;
	}
	
	public BigDecimal getPrice(){
		return price;
	}
	
	public void setPrice(BigDecimal price){
		this.price = price;
	}
	
	public String getUrl(){
		return url;
	}
	
	public void setUrl(String url){
		this.url = url;
	}
	
	public long getCategoryId(){
		return categoryId;
	}
	
	public void setCategoryId(long categoryId){
		this.categoryId = categoryId;
	}
}

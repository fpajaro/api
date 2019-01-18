package com.projects.api.payload.request;

import java.math.BigDecimal;
import java.time.Instant;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class ProductRequest{
	
	@NotBlank
	private String name;
	
	private Instant introDate;
	
	@NotNull
	private BigDecimal price;
	
	@NotBlank
	private String url;
	
	@NotNull
	private long categoryId;
	
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

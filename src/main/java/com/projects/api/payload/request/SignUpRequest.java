package com.projects.api.payload.request;

import javax.validation.constraints.*;

public class SignUpRequest {
    
	@NotBlank
    @Size(min = 4, max = 40)
    private String name;

    @NotBlank
    @Size(min = 3, max = 15)
    private String username;

    @NotBlank
    @Size(max = 40)
    @Email
    private String email;

    @NotBlank
    @Size(min = 6, max = 20)
    private String password;
    
    private boolean canAccessProducts = false;
    
    private boolean canAddProduct = false;
    
    private boolean canSaveProduct = false;
    
    private boolean canAccessCategories = false;
    
    private boolean canAddCategory = false;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

	public boolean canAccessProducts(){
		return canAccessProducts;
	}

	public void setCanAccessProducts(boolean canAccessProducts){
		this.canAccessProducts = canAccessProducts;
	}

	public boolean canAddProduct(){
		return canAddProduct;
	}

	public void setCanAddProduct(boolean canAddProduct){
		this.canAddProduct = canAddProduct;
	}

	public boolean canSaveProduct(){
		return canSaveProduct;
	}

	public void setCanSaveProduct(boolean canSaveProduct){
		this.canSaveProduct = canSaveProduct;
	}

	public boolean canAccessCategories(){
		return canAccessCategories;
	}

	public void setCanAccessCategories(boolean canAccessCategories){
		this.canAccessCategories = canAccessCategories;
	}

	public boolean canAddCategory(){
		return canAddCategory;
	}

	public void setCanAddCategory(boolean canAddCategory){
		this.canAddCategory = canAddCategory;
	}
}

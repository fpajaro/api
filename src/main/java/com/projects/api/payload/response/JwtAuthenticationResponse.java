package com.projects.api.payload.response;

import java.util.HashMap;
import java.util.Map;

public class JwtAuthenticationResponse {
    
    private String bearerToken;
    private Map<String, Boolean> claims = new HashMap<>();
    private String username;
    private boolean isAuthenticated;

	public String getBearerToken(){
		return bearerToken;
	}

	public void setBearerToken(String bearerToken){
		this.bearerToken = bearerToken;
	}

	public Map<String, Boolean> getClaims(){
		return claims;
	}

	public void setClaims(Map<String, Boolean> claims){
		this.claims = claims;
	}
	
	public void addClaim(String type, Boolean value){
		claims.put(type, value);
	}

	public String getUsername(){
		return username;
	}

	public void setUsername(String username){
		this.username = username;
	}

	public boolean isAuthenticated(){
		return isAuthenticated;
	}

	public void setAuthenticated(boolean isAuthenticated){
		this.isAuthenticated = isAuthenticated;
	}
}

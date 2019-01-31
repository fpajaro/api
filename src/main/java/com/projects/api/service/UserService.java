package com.projects.api.service;

import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.projects.api.exception.AppException;
import com.projects.api.model.Claim;
import com.projects.api.model.ClaimType;
import com.projects.api.model.Role;
import com.projects.api.model.RoleName;
import com.projects.api.model.User;
import com.projects.api.payload.request.SignUpRequest;
import com.projects.api.repository.RoleRepository;
import com.projects.api.repository.UserRepository;
import com.projects.api.security.JwtTokenProvider;
import com.projects.api.security.UserPrincipal;

@Service
public class UserService{

	@Autowired
    JwtTokenProvider tokenProvider;
	
	@Autowired
	PasswordEncoder passwordEncoder;
	
	@Autowired
    UserRepository userRepository;

    @Autowired
    RoleRepository roleRepository;
	
	public Map<String, ?> getUserAuthResponse(Authentication auth){
		
		Map<String, ? super Object> resp = new LinkedHashMap<>();
		
		if(auth == null){
			return resp;
		}
		
		String jwt = tokenProvider.generateToken(auth);
		resp.put("bearerToken", jwt);
		
		Object oPrincipal;
		if((oPrincipal = auth.getPrincipal()) == null){
			return resp;
		}
		
		UserPrincipal uPrincipal = (UserPrincipal)oPrincipal;
		Map<String, Boolean> claims = uPrincipal.getClaims();
		
		for(ClaimType type : ClaimType.values()){
			resp.put(type.name(), claims.getOrDefault(type.name(), false));
		}
		
		resp.put("username", uPrincipal.getUsername());
		resp.put("isAuthenticated", auth.isAuthenticated());
		
		return resp;
	}
	
	public Set<Claim> getClaims(SignUpRequest signUpRequest){
		
		Set<Claim> claims = new HashSet<>();
		
		if(signUpRequest == null){
			return claims;
		}
        
    	Claim claim = new Claim();
    	claim.setType(ClaimType.canAccessProducts);
    	claim.setValue(signUpRequest.canAccessProducts());
    	
    	claims.add(claim);
    	
    	claim = new Claim();
    	claim.setType(ClaimType.canAddProduct);
    	claim.setValue(signUpRequest.canAddProduct());
    	
    	claims.add(claim);
    	
    	claim = new Claim();
    	claim.setType(ClaimType.canSaveProduct);
    	claim.setValue(signUpRequest.canSaveProduct());
    	
    	claims.add(claim);
    	
    	claim = new Claim();
    	claim.setType(ClaimType.canAccessCategories);
    	claim.setValue(signUpRequest.canAccessCategories());
    	
    	claims.add(claim);
    	
    	claim = new Claim();
    	claim.setType(ClaimType.canAddCategory);
    	claim.setValue(signUpRequest.canAddCategory());
    	
    	claims.add(claim);
    	
    	return claims;
	}
	
	public User createUser(SignUpRequest signUpRequest){
		
        User user = new User(
        		signUpRequest.getName(),
        		signUpRequest.getUsername(),
                signUpRequest.getEmail(),
                signUpRequest.getPassword());

        user.setPassword(passwordEncoder.encode(user.getPassword()));

        Role userRole = roleRepository.findByName(RoleName.ROLE_USER)
                .orElseThrow(() -> new AppException("User Role not set."));

        user.setRoles(Collections.singleton(userRole));
        
        Set<Claim> claims = getClaims(signUpRequest);
        
        for(Claim claim : claims){
        	user.addClaim(claim);
        }

        User result = userRepository.save(user);
        
        return result;
	}
}

package com.projects.api.model;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.NaturalId;

@Entity
@Table(name = "claims")
public class Claim{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "user_id", nullable = false)
	private User user;
	
	@Enumerated(EnumType.STRING)
    @NaturalId
    @Column(length = 60)
	private ClaimType type;
	
	private boolean value;

	public Long getId(){
		return id;
	}

	public void setId(Long id){
		this.id = id;
	}

	public User getUser(){
		return user;
	}

	public void setUser(User user){
		this.user = user;
	}

	public ClaimType getType(){
		return type;
	}

	public void setType(ClaimType type){
		this.type = type;
	}

	public boolean getValue(){
		return value;
	}

	public void setValue(boolean value){
		this.value = value;
	}
	
	@Override
	public boolean equals(Object o){
		if(this == o) return true;
		if(o == null || getClass() != o.getClass()) return false;
		Claim claim = (Claim)o;
		return Objects.equals(id, claim.id);
	}
	
	@Override
	public int hashCode(){
		return Objects.hash(id);
	}
}

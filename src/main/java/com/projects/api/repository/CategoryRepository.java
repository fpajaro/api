package com.projects.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.projects.api.model.Category;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long>{

}

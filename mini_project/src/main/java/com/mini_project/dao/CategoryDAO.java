package com.mini_project.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mini_project.entity.Category;


public interface CategoryDAO extends JpaRepository<Category, String>{

}

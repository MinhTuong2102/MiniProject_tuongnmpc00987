package com.mini_project.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mini_project.dao.CategoryDAO;
import com.mini_project.entity.Category;
import com.mini_project.services.CategoryService;

@Service
public class CategoryServiceImpl implements CategoryService{
	
	@Autowired
	CategoryDAO cdao ;

	@Override
	public List<Category> findAll() {
		return cdao.findAll();
	}
}

package com.mini_project.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mini_project.dao.RoleDAO;
import com.mini_project.entity.Role;
import com.mini_project.services.RoleService;


@Service
public class RoleServiceImpl implements RoleService{
	@Autowired
	RoleDAO dao ;

	public List<Role> findAll() {
		return dao.findAll();
	}
}

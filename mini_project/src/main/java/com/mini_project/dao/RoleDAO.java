package com.mini_project.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mini_project.entity.Role;

public interface RoleDAO extends JpaRepository<Role, String>{

}

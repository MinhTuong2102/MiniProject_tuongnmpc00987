package com.mini_project.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mini_project.dao.AccountDAO;
import com.mini_project.dao.AuthorityDAO;
import com.mini_project.entity.Account;
import com.mini_project.entity.Authority;
import com.mini_project.services.AuthorityService;

@Service
public class AuthorityServiceImpl implements AuthorityService{
	
	@Autowired
	AuthorityDAO dao ;
	
	@Autowired
	AccountDAO acdao ;
	
	
	public List<Authority> findAuthoritiesOfAdministrators() {
		List<Account> accounts = acdao.getAdministrators();
		return dao.authoritiesOf(accounts);
	}

	public List<Authority> findAll() {
		return dao.findAll();
	}

	public Authority create(Authority auth) {
		return dao.save(auth);
	}

	public void delete(Integer id) {
		 dao.deleteById(id);
	}

}

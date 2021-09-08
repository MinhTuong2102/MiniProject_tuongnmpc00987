package com.mini_project.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mini_project.dao.AccountDAO;
import com.mini_project.entity.Account;
import com.mini_project.services.AccountService;

@Service
public class AccountServiceImpl implements AccountService{
	@Autowired
	AccountDAO dao ;
	
	@Override
	public Account findById(String username){
		return dao.findById(username).get();	
	}

	
	public List<Account> getAdministrators() {
		return dao.getAdministrators();
	}

	
	public List<Account> findAll() {
		return dao.findAll();
	}


	@Override
	public Account create(Account account) {
		return dao.save(account);
	}

	@Override
	public Account update(Account account) {
		return dao.save(account);
	}

	@Override
	public void delete(String username) {
		dao.deleteById(username);
	}
}

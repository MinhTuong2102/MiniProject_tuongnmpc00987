package com.mini_project.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.mini_project.entity.Account;

public interface AccountDAO extends JpaRepository<Account, String>{
	
	@Query("SELECT DISTINCT ar.account FROM Authority ar WHERE ar.role.id IN ('PM','ADMIN')")
	List<Account> getAdministrators();


}

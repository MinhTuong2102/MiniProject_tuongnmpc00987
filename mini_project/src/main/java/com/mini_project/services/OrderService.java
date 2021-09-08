package com.mini_project.services;

import java.util.List;

import com.fasterxml.jackson.databind.JsonNode;
import com.mini_project.entity.Order;


public interface OrderService {
	
	Order create(JsonNode orderData);

	Object findById(Long id);

	List<Order> findByUsername(String username);

}

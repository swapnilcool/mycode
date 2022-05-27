package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.example.demo.OrderRepository;
import com.example.demo.vo.OrderVO;

@Service
public class OrderService {
	
	@Autowired OrderRepository repository;
	
	@Autowired
	RestTemplate template;
	
	public Integer  saveOrUpdate(OrderVO order) {
		repository.save(order);
		ResponseEntity<String> response= template.getForEntity("http://localhost:8080/email?address="+order.getEmail(), String.class);
		return order.getId();
 }

	public List<OrderVO> getOrders() {
		return repository.findAll();
		
	}
}

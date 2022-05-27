package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.EnableJms;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.example.demo.OrderRepository;
import com.example.demo.vo.OrderVO;
@EnableJms
@Service
public class OrderService {
	private static final String MESSAGE_QUEUE = "message_queue";
	@Autowired OrderRepository repository;
	@Autowired JmsTemplate jmsTemplate;
	@Autowired
	RestTemplate template;
	
	public Integer  saveOrUpdate(OrderVO order) {
		repository.save(order);
		//ResponseEntity<String> response= template.getForEntity("http://localhost:8080/email?address="+order.getEmail(), String.class);
		jmsTemplate.convertAndSend(MESSAGE_QUEUE, order.getEmail());
		return order.getId();
 }

	public List<OrderVO> getOrders() {
		return repository.findAll();
		
	}
}

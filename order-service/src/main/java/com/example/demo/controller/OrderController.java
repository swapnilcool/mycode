package com.example.demo.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.service.OrderService;
import com.example.demo.vo.OrderVO;

@EnableEurekaClient
@RestController
@RequestMapping("/order")
public class OrderController{ 
	@Autowired OrderService service;
	
	@PostMapping
	@ResponseStatus(code = HttpStatus.CREATED)
	Integer creatOrder(@Valid @RequestBody OrderVO order) {
	System.out.println(order.getItem());
	System.out.println(order.getPrice());
	return service.saveOrUpdate(order);
	
	}
	
	@GetMapping
	List<OrderVO> getOrders(){
		return service.getOrders();
	}
	@ResponseStatus(code=HttpStatus.BAD_REQUEST)
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public Map<String, String> handleException(MethodArgumentNotValidException exception) {
		Map<String, String> messages = new HashMap<>();
		exception.getAllErrors().forEach(error ->{
			String fieldName = ((FieldError)error).getField();
			String errorMessage = ((FieldError)error).getDefaultMessage();
			messages.put(fieldName, errorMessage);
		});
		return messages;
		
	}	

}

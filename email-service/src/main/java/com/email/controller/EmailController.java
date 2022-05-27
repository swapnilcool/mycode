package com.email.controller;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@EnableEurekaClient
@RestController
public class EmailController {

	@GetMapping("/email")
	String sendEmail(@PathParam("address")  String address) {
		System.out.println("Address"+ address);
		return "Email send Succsefully";
	}
}

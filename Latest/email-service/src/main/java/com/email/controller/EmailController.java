package com.email.controller;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.jms.annotation.EnableJms;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@EnableEurekaClient
@RestController
@EnableJms
public class EmailController {
	@Autowired JmsTemplate jmsTemplate;

private static final String MESSAGE_QUEUE = "message_queue";
//	@GetMapping("/email")
	@JmsListener(destination = MESSAGE_QUEUE)
	//String sendEmail(@PathParam("address")  String address) {
	String sendEmail(String address) {
		System.out.println("Address"+ address);
		return "Email send Succsefully";
	}
}

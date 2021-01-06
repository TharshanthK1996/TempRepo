package com.spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring.model.OrderDetail;
import com.spring.service.RabbitMQListner;

@RestController
@RequestMapping(path = "Order")
public class OrderDetailController {
	@Autowired
	RabbitMQListner rabbitMQlListner;
	
	@PostMapping()
	public String createEmployee(@RequestBody OrderDetail employee) {
		rabbitMQlListner.consumer(employee);
		return "consume order";
	}
}

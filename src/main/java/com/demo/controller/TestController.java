package com.demo.controller;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.demo.service.SendMsgService;

@RestController
@RequestMapping("/test")
public class TestController {
	@Autowired
	private SendMsgService sendMsgService;
	
	@RequestMapping("/send")
	@ResponseBody
	public String send() {
		sendMsgService.sayHi("hello world!");
		return "success!";
	}
}

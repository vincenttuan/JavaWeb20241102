package com.example.mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller // 告知 Spring 本程式是一個 Controller
public class HelloMessageController {
	
	@GetMapping("/hello")
	public String hello() {
		return "hello_message"; // 指的是 thymeleaf 的檔名
	}
	
	
}

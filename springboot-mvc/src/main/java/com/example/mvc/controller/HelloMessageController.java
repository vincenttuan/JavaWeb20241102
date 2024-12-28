package com.example.mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller // 告知 Spring 本程式是一個 Controller
public class HelloMessageController {
	
	@GetMapping("/hello")
	public String hello(Model model) {
		// 利用 model 將資料傳遞給 hello_message.html
		model.addAttribute("message", "Welcome !");
		return "hello_message"; // 指的是 thymeleaf 的檔名
	}
	
	
}

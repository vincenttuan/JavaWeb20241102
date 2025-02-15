package com.example.mvc.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.servlet.http.HttpServletRequest;

@RestController
public class RegisterController {
	
	@GetMapping("/register")
	public String register(HttpServletRequest request) {
		String ip = request.getLocalAddr(); // 取得本機端 ip
		int port = request.getLocalPort(); // 取得本機端 port
		String message = "註冊: " + ip + ":" + port;
		return message;
	}
	
}

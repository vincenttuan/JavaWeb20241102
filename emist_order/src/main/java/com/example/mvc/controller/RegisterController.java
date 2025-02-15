package com.example.mvc.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.servlet.http.HttpServletRequest;

@RestController
public class RegisterController {
	
	@GetMapping("/register")
	public String register(HttpServletRequest request) {
		String portocol = request.getScheme(); // 取得通訊協定 http or https
		String ip = request.getLocalAddr(); // 取得本機端 ip
		int port = request.getLocalPort(); // 取得本機端 port
		String url = portocol + "://" + ip + ":" + port;
		String message = "註冊: " + url;
		return message;
	}
	
	@GetMapping("/unregister")
	public String unregister(HttpServletRequest request) {
		String portocol = request.getScheme(); // 取得通訊協定 http or https
		String ip = request.getLocalAddr(); // 取得本機端 ip
		int port = request.getLocalPort(); // 取得本機端 port
		String url = portocol + "://" + ip + ":" + port;
		String message = "取消註冊: " + url;
		return message;
	}
	
	
}

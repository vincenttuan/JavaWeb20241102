package com.example.mvc.controller;

import java.net.URL;
import java.util.Scanner;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
		// 向 emister_bridge 進行註冊
		try {
			URL bridgeURL = new URL("http://127.0.0.1:8080/emist/register?url=" + url);
			String response = new Scanner(bridgeURL.openStream(), "UTF-8").useDelimiter("\\A").next();
			message += " " + response;
		} catch(Exception e) {
			message += " 失敗:" + e.getMessage();
		} 
		return message;
	}
	
	@GetMapping("/unregister")
	public String unregister(HttpServletRequest request) {
		String portocol = request.getScheme(); // 取得通訊協定 http or https
		String ip = request.getLocalAddr(); // 取得本機端 ip
		int port = request.getLocalPort(); // 取得本機端 port
		String url = portocol + "://" + ip + ":" + port;
		String message = "取消註冊: " + url;
		// 向 emister_bridge 進行取消註冊
		try {
			URL bridgeURL = new URL("http://127.0.0.1:8080/emist/unregister?url=" + url);
			String response = new Scanner(bridgeURL.openStream(), "UTF-8").useDelimiter("\\A").next();
			message += " " + response;
		} catch(Exception e) {
			message += " 失敗:" + e.getMessage();
		} 
		return message;
	}
	
	@GetMapping("/order/{symbol}")
	public String order(@PathVariable String symbol) {
		String message = "下單: " + symbol;
		return message;
	}
	
	
}

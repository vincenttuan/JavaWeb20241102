package com.example.mvc.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/emist")
public class EmisterRegisterController {
	
	@GetMapping("/register")
	public String register(@RequestParam String url) {
		String message = "在 emist_bridger 中註冊 [ " + url + " ] 成功";
		System.out.println(message);
		return message;
	}
	
	@GetMapping("/unregister")
	public String unregister(@RequestParam String url) {
		String message = "在 emist_bridger 中取消註冊 [ " + url + " ] 成功";
		System.out.println(message);
		return message;
	}
	
}

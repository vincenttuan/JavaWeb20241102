package com.example.mvc.controller;

import java.util.LinkedHashSet;
import java.util.Set;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/emist")
public class EmisterRegisterController {
	Set<String> urls = new LinkedHashSet<>(); // 存放已註冊的 url
	
	@GetMapping("/register") // 註冊
	public String register(@RequestParam String url) {
		urls.add(url); // 加入 url 到 urls 中 => 註冊
		String message = "在 emist_bridger 中註冊 [ " + url + " ] 成功, 目前註冊的有 " + urls;
		System.out.println(message);
		return message;
	}
	
	@GetMapping("/unregister") // 取消註冊
	public String unregister(@RequestParam String url) {
		urls.remove(url); // 將 url 自 urls 中移除 => 取消註冊
		String message = "在 emist_bridger 中取消註冊 [ " + url + " ] 成功, 目前註冊的有 " + urls;
		System.out.println(message);
		return message;
	}
	
}

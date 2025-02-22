package com.example.mvc.controller;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.method.annotation.SseEmitter;

import reactor.core.publisher.Flux;

@RestController
@RequestMapping("/chat")
public class ChatController {
	
	@Autowired
	private ChatClient chatClient;
	
	/*
	@GetMapping("/ask")
	public String ask(@RequestParam String question) {
		return chatClient.prompt().user(question).call().content();
	}
	*/
	
	// 逐字回報
	@RequestMapping(value = "/ask", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
	public SseEmitter ask(@RequestParam String question) {
		// 建立發射器
		SseEmitter emitter = new SseEmitter();
		
		// 使用 ChatClient 的 stream 方法來獲取串流回應
		Flux<String> responseFlux = chatClient.prompt().user(question).stream().content();
		
		// 透過訂閱機制將資料逐字傳送給前端
		responseFlux.subscribe(
			word -> { 
				try {
					emitter.send(word); // 逐字送
				} catch (Exception e) {
					emitter.completeWithError(e); // 回報錯誤
				}
			},
			error -> emitter.completeWithError(error),
			emitter::complete
		);
		
		return emitter;
		
	} 
	
	
	
}

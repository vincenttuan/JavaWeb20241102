package com.example.mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.mvc.SendMail;

@RestController
public class SendMailController {
	
	@PostMapping("/sendmail")
	public String send(@RequestParam String to, @RequestParam String header, @RequestParam String content) {
		SendMail sendMail = new SendMail();
		// 傳送 email
		sendMail.send(to, header, content);
		return "Send mail OK";
	}
	
}

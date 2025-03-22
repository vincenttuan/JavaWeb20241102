package com.example.mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.mvc.SendMail;

@RestController
//@CrossOrigin(origins = "http://localhost:5173") // 允許 http://localhost:5173
@CrossOrigin(origins = "*") // 允許來自任何地方的請求
public class SendMailController {
	
	@PostMapping("/sendmail")
	public String send(@RequestParam String to, @RequestParam String header, @RequestParam String content) {
		SendMail sendMail = new SendMail();
		// 傳送 email
		sendMail.send(to, header, content);
		return "Send mail OK";
	}
	
}

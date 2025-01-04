package com.example.mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ResumeController {
	
	// 取得履歷表單 
	@GetMapping("/resume")
	public String getResumeFrom() {
		return "resume_form";
	}
	
}

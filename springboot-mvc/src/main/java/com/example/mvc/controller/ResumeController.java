package com.example.mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.mvc.model.dto.Resume;

@Controller
public class ResumeController {
	
	// 取得履歷表單 
	@GetMapping("/resume")
	public String getResumeFrom() {
		return "resume_form";
	}
	
	// 新增履歷
	@PostMapping("/resume")
	public String addResume(Resume resume, Model model) {
		model.addAttribute("resume", resume);
		return "resume"; // <-- resume.html
	}
	
}

package com.example.mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class BMIController {
	
	// 顯示 bmi 表單
	@GetMapping("/bmi")
	public String showBMIForm() {
		return "bmi_form";
	}
	
	// 計算 bmi
	@PostMapping("/bmi")
	public String getBMI(Model model, @RequestParam double h, @RequestParam double w) {
		// 計算 bmi
		double bmi = w / Math.pow(h/100, 2);
		// 診斷 
		String result = "正常";
		if(bmi > 23) {
			result = "過重";
		} else if(bmi <= 18) {
			result = "過輕";
		}
		
		// 將資料放到 model 中目的是傳給 bmi.html 呈現
		model.addAttribute("h", h);
		model.addAttribute("w", w);
		model.addAttribute("bmi", bmi);
		model.addAttribute("result", result);
		return "bmi"; // 指的是 src/main/resources/templates/bmi.html
	}
	
}

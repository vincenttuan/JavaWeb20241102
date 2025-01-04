package com.example.mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class BMIController {
	
	// 網址範例:localhost:8080/bmi?h=170&w=60
	@GetMapping("/bmi")
	public String getBMI(Model model, @RequestParam double h, @RequestParam double w) {
		// 計算 bmi
		double bmi = w / Math.pow(h/100, 2);
		// 將資料放到 model 中目的是傳給 bmi.html 呈現
		model.addAttribute("h", h);
		model.addAttribute("w", w);
		model.addAttribute("bmi", bmi);
		return "bmi"; // 指的是 src/main/resources/templates/bmi.html
	}
	
}

package com.example.mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/*
 * 介紹URL所帶入的各種參數與路徑
 * 範例:
 *     GET  /api/query?name=John&age=25 查詢參數範例 Query Parameters 
 *     GET  /api/path/John/25           路徑參數範例 Path Variables
 *     POST /api/form                   表單參數範例 Form Parameters
 *              表單資料: name=John&age=25
 *     POST /api/json                   JSON Body 範例 可將 Json 資料注入到指定物件中(例如: User)
 *              Json資料: {"name": "John", "age": 25}
*/
@Controller
@RequestMapping("/api")
public class APIController {
	
	// 1.存取範例: /api/query?name=John&age=25
	//                       name 與 age 一定要輸入
	@GetMapping("/query")
	public String handleQueryParamters(@RequestParam String name, @RequestParam Integer age, Model model) {
		// 將 name 與 age 組合一個訊息
		String message = "姓名:" + name + ", 年齡:" + age;
		
		model.addAttribute("message", message);
		return "hello_message"; // 利用 hello_message.html 來呈現 message 資料內容
	}
	
	// 2.存取範例: /api/find?name=John&age=25
	//            /api/find?name=John  
	//             name 一定要輸入但是 age 可以選擇不輸入(預設值=0)
	@GetMapping("/find")
	public String handleQueryParamters2(@RequestParam String name, 
			@RequestParam(required = false, defaultValue = "0") Integer age, 
			Model model) {
		// 將 name 與 age 組合一個訊息
		String message = "姓名:" + name + ", 年齡:" + age;
		
		model.addAttribute("message", message);
		return "hello_message"; // 利用 hello_message.html 來呈現 message 資料內容
	}
	
	// 3.隨堂練習
	//   請設計一個可以計算出 BMI 資料的 URL 網路服務
	//   範例路徑: /api/bmi?h=170&w=60
	//   執行結果: BMI=20.76
	@GetMapping("/bmi")
	public String bmi(@RequestParam double h, @RequestParam double w, Model model) {
		double bmiValue = w / Math.pow(h/100, 2);
		String message = String.format("bmi=%.2f", bmiValue);
		
		model.addAttribute("message", message);
		return "hello_message"; // 利用 hello_message.html 來呈現 message 資料內容
	}
	
	// 4.存取範例 /api/path/John/25 <-- 參數內容是放在路徑中
	//           /api/path/Mary/30 <-- 參數內容是放在路徑中
	
	@GetMapping("/path/{name}/{age}")
	public String handlePathVariables(@PathVariable String name, @PathVariable Integer age, Model model) {
		// 將 name 與 age 組合一個訊息
		String message = "姓名:" + name + ", 年齡:" + age;
		
		model.addAttribute("message", message);
		return "hello_message"; // 利用 hello_message.html 來呈現 message 資料內容
	}
	
}

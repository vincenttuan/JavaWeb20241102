package com.example.mvc.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.mvc.model.dto.User;

/*
 * User 類有二個欄位
 * - name
 * - age
 * 
 * List<User> users 存放所有 user 資料
 * 
 * API
 * GET  /user 查詢所有使用者
 * GET  /user/{id} 查詢指定使用者
 * POST /user 新增使用者
 * GET  /user/{id} 修改使用者(例如:修改 name 與 age)
 * GET  /user/{id} 刪除使用者
 * 
 * */

@Controller
@RequestMapping("/user")
public class UserController {
	
	private static List<User> users = new ArrayList<>();
	
	// 查詢所有使用者
	@GetMapping
	public String getAllUsers(Model model) {
		model.addAttribute("users", users);
		return "user";
	}
	
	// 查詢指定使用者 
	@GetMapping("/{id}")
	public String getUserById(@PathVariable int id, Model model) {
		model.addAttribute("user", users.get(id));
		return "user";
	}
	
	// 新增使用者
	@PostMapping
	public String addUser(User user, Model model) {
		// 將 user 物件加入到 users 集合中保存
		users.add(user);
		model.addAttribute("message", "User 新增成功");
		return "user";
	}
	
	
}

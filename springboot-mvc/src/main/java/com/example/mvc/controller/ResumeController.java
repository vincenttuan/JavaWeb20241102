package com.example.mvc.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.mvc.model.dto.Resume;
import com.example.mvc.repository.ResumeRepository;

@Controller
public class ResumeController {
	
	// String 會自行尋找ResumeRepository的實現類也就是 ResumeRepositoryImpl
	@Autowired
	private ResumeRepository resumeRepository;
	
	// 取得履歷表單 
	@GetMapping("/resume")
	public String getResumeFrom(Model model) {
		List<Resume> resumes = resumeRepository.findAllResumes();
		model.addAttribute("resumes", resumes);
		return "resume_form";
	}
	
	// 新增履歷
	@PostMapping("/resume")
	public String addResume(Resume resume, Model model) {
		// 新增到資料表
		resumeRepository.addResume(resume);
		
		model.addAttribute("resume", resume);
		return "resume"; // <-- resume.html
	}
	
	// 取得指定 id 的履歷, 並回傳 resume_edit.html
	@GetMapping("/resume/{id}")
	public String getResume(@PathVariable Integer id, Model model) {
		// 透過 id 得到 resume 資料
		Resume resume = resumeRepository.getResumeById(id);
		
		model.addAttribute("resume", resume);
		return "resume_edit"; // 修改 resume 頁面
	}
	
	@PutMapping("/resume/{id}")
	public String updateResume(@PathVariable Integer id, Resume resume) {
		// 修改
		resumeRepository.updateResume(id, resume);
		// 重導到首頁
		return "redirect:/resume";
	}
	
	
}

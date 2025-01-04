package com.example.mvc.repository;

import java.util.List;

import com.example.mvc.model.dto.Resume;

public interface ResumeRepository {
	List<Resume> findAllResumes();
	void addResume(Resume resume);
}

package com.example.mvc.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.example.mvc.model.dto.Resume;

@Repository
public class ResumeRepositoryImpl implements ResumeRepository {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Override
	public List<Resume> findAllResumes() {
		String sql = "select id, name, birth, gender, education, skill, memo from resume";
		return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Resume.class));
	}

	@Override
	public void addResume(Resume resume) {
		// TODO Auto-generated method stub
		
	}
	
}

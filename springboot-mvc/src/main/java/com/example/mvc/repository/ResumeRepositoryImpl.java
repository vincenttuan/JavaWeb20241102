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
		String sql = "insert into resume(name, birth, gender, education, skill, memo) values(?, ?, ?, ?, ?, ?)";
		jdbcTemplate.update(sql, 
							resume.getName(), resume.getBirth(), resume.getGender(), 
							resume.getEducation(), resume.getSkill(), resume.getMemo());
		
	}

	@Override
	public Resume getResumeById(Integer id) {
		String sql = "select id, name, birth, gender, education, skill, memo from resume where id=?";
		return jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<>(Resume.class), id);
	}

	@Override
	public void updateResume(Integer id, Resume resume) {
		String sql = "update resume set name=?, birth=?, gender=?, education=?, skill=?, memo=? where id=?";
		jdbcTemplate.update(sql, 
							resume.getName(), resume.getBirth(), resume.getGender(), 
							resume.getEducation(), resume.getSkill(), resume.getMemo(), id);
	}

	@Override
	public void deleteResume(Integer id) {
		String sql = "delete from resume where id=?";
		jdbcTemplate.update(sql, id);
	}
	
}

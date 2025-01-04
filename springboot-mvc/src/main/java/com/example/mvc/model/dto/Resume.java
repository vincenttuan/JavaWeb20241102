package com.example.mvc.model.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Resume {
	private String name;
	private String birth;
	private String gender;
	private String education;
	private String skill;
	private String memo;
	
}

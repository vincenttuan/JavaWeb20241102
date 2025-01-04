package com.example.mvc.model.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class BMI {
	private Double h;
	private Double w;
	private Double bmiValue;
	private String result;
	
}

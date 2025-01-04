package com.example.mvc.model.dto;

public class BMI {
	private Double h;
	private Double w;
	private Double bmiValue;
	private String result;
	
	public BMI() {
		
	}
	
	public BMI(Double h, Double w, Double bmiValue, String result) {
		this.h = h;
		this.w = w;
		this.bmiValue = bmiValue;
		this.result = result;
	}
	
	public Double getH() {
		return h;
	}
	public void setH(Double h) {
		this.h = h;
	}
	public Double getW() {
		return w;
	}
	public void setW(Double w) {
		this.w = w;
	}
	public Double getBmiValue() {
		return bmiValue;
	}
	public void setBmiValue(Double bmiValue) {
		this.bmiValue = bmiValue;
	}
	public String getResult() {
		return result;
	}
	public void setResult(String result) {
		this.result = result;
	}
	
	
	
	
}

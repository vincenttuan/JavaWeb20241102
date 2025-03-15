package com.example.tx.exception;

// 數量或餘額不足
public class InsufficientAmount extends Exception {
	public InsufficientAmount(String message) {
		super(message);
	}
}

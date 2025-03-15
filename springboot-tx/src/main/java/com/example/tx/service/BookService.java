package com.example.tx.service;

import com.example.tx.exception.InsufficientAmount;

public interface BookService {
	// 書本價格
	Integer getBookPrice(Integer bookId);
	
	// 書本庫存
	Integer getBookAmount(Integer bookId);
	
	// 帳戶餘額
	Integer getWalletBalance(String username);
	
	// 更新庫存
	void reduceBookAmount(Integer bookId, Integer amountToReduce) throws InsufficientAmount;
	
	// 更新餘額
	void updateWalletBalance(String username, Integer bookPrice) throws InsufficientAmount;
	
}

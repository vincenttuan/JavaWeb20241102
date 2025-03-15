package com.example.tx.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.tx.exception.InsufficientAmount;
import com.example.tx.repository.BookInventoryRepository;
import com.example.tx.repository.BookRepository;
import com.example.tx.repository.WalletRepository;
import com.example.tx.service.BookService;

@Service
public class BookServiceImpl implements BookService {
	@Autowired
	private BookRepository bookRepository;
	
	@Autowired
	private BookInventoryRepository bookInventoryRepository;
	
	@Autowired
	private WalletRepository walletRepository;
	
	// 取得書本價格
	@Override
	public Integer getBookPrice(Integer bookId) {
		return bookRepository.getBookPrice(bookId);
	}
	
	// 取得書本庫存
	@Override
	public Integer getBookAmount(Integer bookId) {
		return bookInventoryRepository.getBookAmount(bookId);
	}
	
	// 取得帳戶餘額
	@Override
	public Integer getWalletBalance(String username) {
		return walletRepository.getWalletBalance(username);
	}
	
	// 更新書本庫存
	@Override
	public void reduceBookAmount(Integer bookId, Integer amountToReduce) throws InsufficientAmount {
		// 1. 取得目前庫存
		Integer bookAmount = getBookAmount(bookId);
		// 2. 若庫存不足(目前庫存量 < amountToReduce)則拋出例外
		if(bookAmount < amountToReduce) {
			throw new InsufficientAmount("庫存不足 " + bookAmount + " < " + amountToReduce);
		}
		// 3. 更新庫存
		bookInventoryRepository.updateBookAmount(amountToReduce, bookId);
	}
	
	// 更新餘額
	@Override
	public void updateWalletBalance(String username, Integer bookPrice) throws InsufficientAmount {
		// 1. 取得目前餘額
		Integer walletBalance = getWalletBalance(username);
		// 2. 若餘額不足(目前餘額 < bookPrice)則拋出例外
		if(walletBalance < bookPrice) {
			throw new InsufficientAmount("餘額不足 " + walletBalance + " < " + bookPrice);
		}
		// 3. 更新餘額
		walletRepository.updateWalletBalance(bookPrice, username);
	}

}

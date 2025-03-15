package com.example.tx.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.tx.service.BookService;
import com.example.tx.service.BuyService;

// 買書服務(交易)
@Service
public class BuyServiceImpl implements BuyService {
	
	@Autowired
	private BookService bookService;
	
	// 買書的行為
	@Override
	public void buyOneBook(String username, Integer bookId) {
		System.out.println(username + " 要買一本書, bookId = " + bookId);
		// 1. 查詢書本價格
		Integer bookPrice = bookService.getBookPrice(bookId);
		System.out.println("bookId = " + bookPrice + " 價格 = " + bookPrice);
		
		// 2. 減去庫存
		bookService.reduceBookAmount(bookId, bookPrice);
		System.out.println("bookId = " + bookId + " 減去一本書的庫存");
		
		// 3. 修改餘額
		bookService.updateWalletBalance(username, bookPrice);
		System.out.println(username + " 的帳戶餘額減去 " + bookPrice);
		
		// 4. 結帳完成
		System.out.println(username + " 結帳完成");
		
		// 5 ...(若有必要可以繼續做其他事情)
	}
	
}

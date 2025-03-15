package com.example.tx.service.impl;

import org.springframework.stereotype.Service;

import com.example.tx.service.BookService;

@Service
public class BookServiceImpl implements BookService {

	@Override
	public Integer getBookPrice(Integer bookId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Integer getBookAmount(Integer bookId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Integer getWalletBalance(String username) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void reduceBookAmount(Integer bookId, Integer amountToReduce) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateWalletBalance(String username, Integer bookPrice) {
		// TODO Auto-generated method stub
		
	}

}

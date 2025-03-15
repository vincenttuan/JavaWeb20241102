package com.example.tx;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.tx.service.BuyService;

@SpringBootTest
public class TestBuyOneBook {
	
	@Autowired
	private BuyService buyService;
	
	@Test
	public void test() {
		
		String username = "John";
		Integer bookId = 2;
		
		try {
			buyService.buyOneBook(username, bookId);
		} catch (Exception e) {
			System.out.println(e);
		}
		
		
	}
	
}

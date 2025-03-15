package com.example.tx.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Book {
	
	private Integer bookId; // 書號
	
	private String bookName; // 書名
	
	private Integer bookPrice; // 價格
	
}

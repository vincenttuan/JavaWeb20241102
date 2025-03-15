package com.example.tx.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity // 自動生成資料表
public class BookInventory {
	@Id
	private Integer bookId; // 書號
	@Column
	private Integer bookAmount; // 庫存數量
	
}

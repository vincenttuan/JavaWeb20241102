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
public class Wallet {
	@Id
	private String username; // 用戶名
	@Column
	private Integer balance; // 餘額
}

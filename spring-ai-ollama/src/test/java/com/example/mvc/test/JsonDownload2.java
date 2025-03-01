package com.example.mvc.test;

import java.util.List;

public class JsonDownload2 {
	public static void main(String[] args) throws Exception {
		// 從殖利率, 本益比, 股價淨值比來分析台積電
		System.out.println("20250227");
		List<String> row = JsonDownload.getDataBySymbol("20250227", "2330");
		System.out.printf("證券代號:%s 證券名稱:%s 收盤價:%s 殖利率(%%):%s 本益比:%s 股價淨值比:%s%n",
				row.get(0), row.get(1), row.get(2), row.get(3), row.get(5), row.get(6));
		
		System.out.println("20240227");
		List<String> preRow = JsonDownload.getDataBySymbol("20240227", "2330");
		System.out.printf("證券代號:%s 證券名稱:%s 收盤價:%s 殖利率(%%):%s 本益比:%s 股價淨值比:%s%n",
				preRow.get(0), preRow.get(1), preRow.get(2), preRow.get(3), preRow.get(5), preRow.get(6));
		
		System.out.println("請問是否可以買進 ?");
	}
}

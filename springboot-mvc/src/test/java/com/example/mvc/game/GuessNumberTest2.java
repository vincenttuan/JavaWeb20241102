package com.example.mvc.game;

import java.util.Scanner;

public class GuessNumberTest2 {
	public static void main(String[] args) {
		int[] ans = {9, 1, 2, 8}; // 答案
		
		do {
			Scanner scanner = new Scanner(System.in);
			System.out.print("請輸入數字不重複的四位數(1~9) => ");
			int data = scanner.nextInt(); // 讀取整行資料
			int[] gus = {
						data/1000, data/100%10, data/10%10, data%10
					};
			
			
			
		} while(true);
	}
	
	// 判斷
	public static int[] check(int[] ans, int[] gus) {
		int[] result = {0, 0}; // ? A, ? B
		// 判斷 A : 數字正確, 位置正確
		int acount = 0;
		for(int i=0;i<4;i++) {
			if(ans[i] == gus[i]) {
				acount++;
				continue;
			}
		}
		result[0] = acount;
		
		// 判斷 B : 數字正確, 位置不正確
		int bcount = 0;
		for(int i=0;i<4;i++) {
			for(int k=0;k<4;k++) {
				if(ans[i] == gus[k]) {
					bcount++;
					continue;
				}
			}
		}
		// bcount 要減去 acount 的資訊避免重複計算
		bcount = bcount - acount;
		result[1] = bcount;
		
		return result;
	}
	
	
}

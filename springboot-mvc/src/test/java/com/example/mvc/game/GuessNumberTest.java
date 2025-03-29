package com.example.mvc.game;

public class GuessNumberTest {

	public static void main(String[] args) {
		int[] ans = {9, 1, 2, 8}; // 答案
		int[] gus = {2, 4, 6, 8}; // 猜測
		
		// 判斷 A : 數字正確, 位置正確
		int acount = 0;
		for(int i=0;i<4;i++) {
			if(ans[i] == gus[i]) {
				acount++;
				continue;
			}
		}
		System.out.printf("%dA ", acount);
		
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
		System.out.printf("%dB%n ", bcount);
	}

}

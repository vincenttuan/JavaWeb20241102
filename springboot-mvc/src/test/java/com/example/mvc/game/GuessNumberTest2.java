package com.example.mvc.game;

import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
import java.util.Set;

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
			int[] result = check(ans, gus);
			System.out.printf("%dA %dB%n", result[0], result[1]);
			if(result[0] == 4) {
				System.out.println("恭喜答對了~");
				scanner.close();
				break;
			}
			scanner.close();
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
	
	// 產生動態答案
	public static int[] getRandomAns() {
		Set<Integer> setNumbers = new LinkedHashSet<>();
		while(setNumbers.size() < 4) {
			setNumbers.add(new Random().nextInt(9) + 1);
		}
		// Set -> List -> int[]
		List<Integer> listNumbers = new LinkedList<>(setNumbers);
		int[] ans = {
				listNumbers.get(0),
				listNumbers.get(1),
				listNumbers.get(2),
				listNumbers.get(3)
		};
		return ans;
	}
	
}

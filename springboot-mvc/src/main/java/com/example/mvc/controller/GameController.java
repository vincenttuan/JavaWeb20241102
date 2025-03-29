package com.example.mvc.controller;

import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;
import java.util.Set;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/game")
@CrossOrigin(originPatterns = "*")
public class GameController {
	
	private int[] ans = getRandomAns(); // 動態答案 
	
	// 玩家猜測
	@GetMapping("/guess")
	public String checkGuess(@RequestParam String num) {
		
		int[] result = null;
		return num + " " + result[0] + "A " + result[1] + "B";
	}
	
	// 判斷服務
	public int[] check(int[] ans, int[] gus) {
		int[] result = {0, 0}; // ?A ?B
		// 判斷 A : 數字正確, 位置正確
		int acount = 0;
		for(int i=0;i<4;i++) {
			if(ans[i] == gus[i]) {
				acount++;
				continue;
			}
		}
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
		// bcount 要減去 account 避免重複計算
		bcount -= acount;
		
		result[0] = acount;
		result[1] = bcount;
		return result;
	}
	
	// 產生動態答案
	public int[] getRandomAns() {
		Set<Integer> setNumbers = new LinkedHashSet<>();
		while (setNumbers.size() < 4) {
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

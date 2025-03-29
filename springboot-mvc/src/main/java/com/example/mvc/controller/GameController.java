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
	
	// 玩家猜測
	@GetMapping("/guess")
	public String checkGuess(@RequestParam String num) {
		
		int[] result = null;
		return num + " " + result[0] + "A " + result[1] + "B";
	}
	
	// 判斷服務
	
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

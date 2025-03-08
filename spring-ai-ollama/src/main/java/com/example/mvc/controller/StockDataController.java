package com.example.mvc.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.mvc.entity.StockData;
import com.example.mvc.service.StockDataService;

@RestController
@RequestMapping("/api/stock")
public class StockDataController {
	
	@Autowired
	private StockDataService stockDataService;
	
	@GetMapping("/symbol/{symbol}")
	public ResponseEntity<List<StockData>> getStockDataBySymbol(@PathVariable String symbol) {
		List<StockData> stockDatas = stockDataService.getStockDataBySymbol(symbol);
		
		return ResponseEntity.ok(stockDatas);
		
	}
	
}

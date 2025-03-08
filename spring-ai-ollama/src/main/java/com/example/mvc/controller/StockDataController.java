package com.example.mvc.controller;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.mvc.entity.StockData;
import com.example.mvc.service.StockDataService;
import com.google.gson.Gson;

@RestController
@RequestMapping("/api/stock")
public class StockDataController {
	
	@Autowired
	private StockDataService stockDataService;
	
	@GetMapping("/symbol/{symbol}")
	// 範例連結: http://localhost:8080/api/stock/symbol/2330
	public ResponseEntity<List<StockData>> getStockDataBySymbol(@PathVariable String symbol) {
		List<StockData> stockDatas = stockDataService.getStockDataBySymbol(symbol);
		return ResponseEntity.ok(stockDatas);
	}
	
	@GetMapping("/import/{date}")
	// 範例連結: http://localhost:8080/api/stock/import/20250307
	public String importStockDataByDate(@PathVariable String date) throws Exception {
		List<List<String>> data = getData(date);
		return data.toString();
	}
	
	// 取得股票資訊
	private List<List<String>> getData(String date) throws Exception {
		// Json URL
		String urlString = "https://www.twse.com.tw/rwd/zh/afterTrading/BWIBBU_d?response=json&date=" + date;
		
		URL url = new URL(urlString);
		
		// 建立連線
		HttpURLConnection connection = (HttpURLConnection)url.openConnection();
		connection.setRequestMethod("GET");
		
		BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
		
		String inputLine;
		StringBuilder response = new StringBuilder();
		
		while((inputLine = reader.readLine()) != null) {
			response.append(inputLine);
		}
		reader.close();
		
		Gson gson = new Gson();
		String jsonString = response.toString();
		Map<String, Object> map = gson.fromJson(jsonString, Map.class);
		
		// 取得 data 欄位資料
		try {
			List<List<String>> data = (List<List<String>>)map.get("data");
			return data;
		} catch (Exception e) {
			System.out.println("查無資料");
		}
		return null;
	}
	
}

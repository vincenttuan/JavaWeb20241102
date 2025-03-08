package com.example.mvc.controller;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.mvc.entity.StockData;
import com.example.mvc.service.StockDataService;
import com.google.gson.Gson;

@RestController
@RequestMapping("/api/stock")
@CrossOrigin(origins = "http://localhost:8080")
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
		List<List<Object>> data = getData(date);
		if(data == null) {
			return "無資料可供匯入";
		}
		
		// 20250307 轉變成 2025-03-07 
		date = date.substring(0, 4) + "-" + date.substring(4, 6) + "-" + date.substring(6); // 格式:yyyy-MM-dd
		
		// 匯入資料-準備資料
		List<StockData> stockDatas = new ArrayList<>();
		for(List<Object> row : data) {
			//      "股票代號","股票名稱","收盤價","殖利率(%)","股利年度","本益比","股價淨值比","財報年/季"
			// row -> 1101, 台泥, 34.50, 2.90, 112.0, 28.99, 1.08, 113/3
			//         0     1      2     3     4       5     6     7  
			// 建立 StockData 物件
			try {
				StockData stockData = new StockData();
				stockData.setDate(date);
				stockData.setSymbol(row.get(0)+""); // 股票代號
				stockData.setName(row.get(1)+""); // 股票名稱
				stockData.setPrice(new BigDecimal((row.get(2)+"").equals("-") ? "0" : (row.get(2)+"").replaceAll(",", ""))); // 收盤價
				stockData.setYield(new BigDecimal((row.get(3)+"").equals("-") ? "0" : (row.get(3)+""))); // 殖利率(%)
				stockData.setYear(new BigDecimal((row.get(4)+"").equals("-") ? "0" : (row.get(4)+"")).intValue()); // 股利年度
				stockData.setPe(new BigDecimal((row.get(5)+"").equals("-") ? "0" : (row.get(5)+"").replaceAll(",", ""))); // 本益比
				stockData.setPb(new BigDecimal((row.get(6)+"").equals("-") ? "0" : (row.get(6)+""))); // 股價淨值比
				stockData.setPeriod(row.get(7) + ""); // 財報年/季
				
				stockDatas.add(stockData);	
			} catch (Exception e) {
				System.out.println(row + ":" + e);
			}
			//return stockDatas + "";
		}
		
		// 匯入資料-執行匯入
		stockDataService.saveStockData(date, stockDatas);
		return "匯入成功";
	}
	
	// 取得股票資訊
	private List<List<Object>> getData(String date) throws Exception {
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
			List<List<Object>> data = (List<List<Object>>)map.get("data");
			return data;
		} catch (Exception e) {
			System.out.println("查無資料");
		}
		return null;
	}
	
}

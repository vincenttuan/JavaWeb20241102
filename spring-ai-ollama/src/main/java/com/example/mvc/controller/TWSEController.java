package com.example.mvc.controller;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;

@RestController
public class TWSEController {
	
	@GetMapping
	public String index() throws Exception {
		return getData();
	}
	
	// 取得股票資訊
	private String getData() throws Exception {
		// Json URL
		String urlString = "https://www.twse.com.tw/rwd/zh/afterTrading/BWIBBU_d?response=json";
		
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
		List<List<String>> data = (List<List<String>>)map.get("data");
		// 過濾資料
		for(List<String> row : data) {
			try {
				Double r = Double.parseDouble(row.get(3)); // 殖利率
				Double pe = Double.parseDouble(row.get(5)); // 本益比
				Double pb = Double.parseDouble(row.get(6)); // 股價淨值比
				if(r > 7 && (pe > 15 && pe < 25) && pb < 1) {
					return String.format("證券代號:%s 證券名稱:%s 收盤價:%s 殖利率(%%):%s 本益比:%s 股價淨值比:%s%n",
							row.get(0), row.get(1), row.get(2), row.get(3), row.get(5), row.get(6));
				}
			} catch (Exception e) {
				continue;
			}
		}
		
		return "";
	}
	
}

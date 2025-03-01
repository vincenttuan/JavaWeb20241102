package com.example.mvc.test;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class JsonDownload {
	
	public static void main(String[] args) throws Exception {
		// Json URL
		String urlString = "https://www.twse.com.tw/rwd/zh/afterTrading/BWIBBU_d?response=json";
		
		// 創建 URL 物件
		URL url = new URL(urlString);
		
		// 建立連線
		HttpURLConnection connection = (HttpURLConnection)url.openConnection();
		connection.setRequestMethod("GET");
		
		// 讀取 JSON 資料
		// connection.getInputStream() 得到 bytes 串流
		// InputStreamReader 將 bytes 串流轉 chars 串流
		// BufferedReader 將 chars 串流放到記憶體中方便 Java 程式可以逐行讀取
		BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
		
		String inputLine; // 用來存放逐行資料
		StringBuilder response = new StringBuilder(); // 將每筆逐行資料累積起來
		
		// 將 JSON 資料讀取到 response 容器中
		// 讀到 null 表示檔尾(讀取完畢)
		while((inputLine = reader.readLine()) != null) {
			response.append(inputLine);
		}
		reader.close();
		
		// 設定一個字串變數來放 json 字串資料
		String jsonString = response.toString();
		
		System.out.println(jsonString);
		
		
		
		
		
		
	}
	
}

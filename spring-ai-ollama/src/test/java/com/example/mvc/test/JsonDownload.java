package com.example.mvc.test;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;
import java.util.Map;

import com.google.gson.Gson;

public class JsonDownload {
	
	public static List<List<String>> getData(String date) throws Exception {
		// Json URL
		String urlString = "https://www.twse.com.tw/rwd/zh/afterTrading/BWIBBU_d?date=" + date + "&response=json";
		
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
		
		// 利用 gson 來分析資料
		Gson gson = new Gson();
		
		// 解析成 Map 類型來處理資料
		Map<String, Object> map = gson.fromJson(jsonString, Map.class);
		// 取得 fields 內的欄位資料
		List<String> fields = (List<String>)map.get("fields");
		// 取得 data 內的股票資料
		List<List<String>> data = (List<List<String>>)map.get("data");
		
		return data;
	}
	
	public static List<String> getDataBySymbol(String date, String symbol) throws Exception {
		List<List<String>> data = getData(date);
		for(List<String> row : data) {
			if(row.get(0).equals(symbol)) {
				return row;
			}
		}
		return null;
	}
	
	public static void main(String[] args) throws Exception {
		List<List<String>> data = getData("20250227");
		// 過濾出殖利率(r) > 7, 本益比(pe) > 20, 股價淨值比(pb) < 1
		for(List<String> row : data) {
			try {
				Double r = Double.parseDouble(row.get(3));
				Double pe = Double.parseDouble(row.get(5));
				Double pb = Double.parseDouble(row.get(6));
				if(r > 7 && (pe > 15 && pe < 25) && pb < 1) {
					//System.out.println(row);
					System.out.println("20250227");
					System.out.printf("證券代號:%s 證券名稱:%s 收盤價:%s 殖利率(%%):%s 本益比:%s 股價淨值比:%s%n",
							row.get(0), row.get(1), row.get(2), row.get(3), row.get(5), row.get(6));
					
					System.out.println("20240227");
					List<String> preRow = getDataBySymbol("20240227", row.get(0));
					System.out.printf("證券代號:%s 證券名稱:%s 收盤價:%s 殖利率(%%):%s 本益比:%s 股價淨值比:%s%n",
							preRow.get(0), preRow.get(1), preRow.get(2), preRow.get(3), preRow.get(5), preRow.get(6));
					
				}
			} catch (Exception e) {
				continue;
			}
		}
		
		
	}
	
}

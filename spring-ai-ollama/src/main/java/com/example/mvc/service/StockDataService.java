package com.example.mvc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import com.example.mvc.entity.StockData;

/**
 * StockDataService 提供對股票資料表(stock_data)的操作服務
 * 
 *  功能:
 *  - 儲存股票資料到資料表中
 *  - 查詢特定單一股票資料(根據 symbol)
 * */
@Service
public class StockDataService {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	// 儲存股票資料到資料表中
	public void saveStockData(String date, List<StockData> stockDatas) {
		// 檢查資料表中是否已有 date 的紀錄, 面免重覆匯入
		String checkDateSql = "select count(*) from stock_date where date = ?";
		int count = jdbcTemplate.queryForObject(checkDateSql, Integer.class, date);
		
		if(count > 0) {
			System.out.println("資料表中已有 " + date + " 的資料");
			return;
		}
		
		// SQL 新增語句
		String insertSql = "insert into stock_data (date, symbol, name, price, yield, year, pe, pb, period) "
				+ " values (?, ?, ?, ?, ?, ?, ?, ?, ?)";
		
		// 逐一將 stockData 物件新增到資料表中 
		stockDatas.forEach(stockData -> {
			jdbcTemplate.update(insertSql,
				stockData.getDate(),  // 股票資料日期 (yyyy-MM-dd)
				stockData.getSymbol(), // 股票代號
				stockData.getName(),  // 股票名稱
				stockData.getPrice(), // 收盤價
				stockData.getYield(), // 殖利率
				stockData.getYear(), // 股利年度
				stockData.getPe(), // 本益比
				stockData.getPb(), // 股價淨值比
				stockData.getPeriod() // 財報年/季
			);
		});
	}
	
	// 查詢特定股票資料
	public List<StockData> getStockDataBySymbol(String symbol) {
		// SQL 查詢語句
		String selectSql = "select id, date, symbol, name, price, yield, year, pe, pb, period from stock_data where symbol = ?";
		// 會自動將資料表中的紀錄逐筆封裝在 StockData 物件中
		return jdbcTemplate.query(selectSql, new BeanPropertyRowMapper<>(StockData.class), symbol);
	}
	
	
}

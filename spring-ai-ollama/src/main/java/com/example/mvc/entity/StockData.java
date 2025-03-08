package com.example.mvc.entity;

import java.math.BigDecimal;

/* 
 * StockData 是用來對應 stock_data 資料表中的紀錄
 * stock_data 資料表
 * ===============================================================
	create table stock_data (
		id bigint auto_increment primary key,
	    date date not null, -- 日期欄位 'yyyy-MM-dd' 格式
	    symbol varchar(10), -- 證券代號 
		name varchar(10), -- 證券名稱
	    price decimal(10, 2), -- 收盤價
	    yield decimal(5, 2), -- 殖利率(%)
	    year int, -- 股利年度
	    pe decimal(5, 2), -- 本益比 (pe: price to earnings ratio)
	    pb decimal(5, 2), -- 股價淨值比 (pb: price to book ratio)
	    period varchar(10) -- 財報年/季
	)
 * ===============================================================
*/
public class StockData {
	private Long id; // 自動新增的序號
	private String date; // 日期 格式 'yyyy-MM-dd'
	private String symbol; // 證券代號 
	private String name; // 證券名稱
	private BigDecimal price; // 收盤價
	private BigDecimal yield; // 殖利率
	private Integer year; // 股利年度
	private BigDecimal pe; // 本益比
	private BigDecimal pb; // 股價淨值比
	private String period; // 財報年/季
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getSymbol() {
		return symbol;
	}
	public void setSymbol(String symbol) {
		this.symbol = symbol;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public BigDecimal getPrice() {
		return price;
	}
	public void setPrice(BigDecimal price) {
		this.price = price;
	}
	public BigDecimal getYield() {
		return yield;
	}
	public void setYield(BigDecimal yield) {
		this.yield = yield;
	}
	public Integer getYear() {
		return year;
	}
	public void setYear(Integer year) {
		this.year = year;
	}
	public BigDecimal getPe() {
		return pe;
	}
	public void setPe(BigDecimal pe) {
		this.pe = pe;
	}
	public BigDecimal getPb() {
		return pb;
	}
	public void setPb(BigDecimal pb) {
		this.pb = pb;
	}
	public String getPeriod() {
		return period;
	}
	public void setPeriod(String period) {
		this.period = period;
	}
	
	
	
}

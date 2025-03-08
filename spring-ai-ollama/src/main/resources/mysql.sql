-- 建立 stock_data 資料表
create table stock_data (
	id bigint auto_increment primary key,
    date date not null, -- 日期欄位 'yyyy-MM-dd' 格式
    symbol varchar(10), -- 證券代號 
	name varchar(10), -- 證券名稱
    price decimal(10, 2), -- 收盤價
    yield decimal(10, 2), -- 殖利率(%)
    year int, -- 股利年度
    pe decimal(10, 2), -- 本益比 (pe: price to earnings ratio)
    pb decimal(10, 2), -- 股價淨值比 (pb: price to book ratio)
    period varchar(10) -- 財報年/季
)
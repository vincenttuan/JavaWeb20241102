use web;
-- 建立 resume 資料表 
create table if not exists resume(
	id int primary key auto_increment,
    name varchar(50) not null,
    birth varchar(20) not null,
    gender varchar(2) not null,
    education varchar(20) not null,
    skill varchar(100),
    memo varchar(255)
);
package javaweb.model.dao.impl;

/*
 * 資料表名稱: todo
 * +----+------+-----------+
 * | id | text | completed |
 * +----+------+-----------+
 * | 1  | Task1|  true(1)  |  true  在資料表中會用 1 呈現
 * | 2  | Task2|  false(0) |  false 在資料表中會用 0 呈現
 * +----+------+-----------+
 * 
 * 建立 todo 資料表 SQL:
   create table if not exists todo(
   	id int primary key auto_increment comment '序號',
   	text varchar(50) not null unique comment '工作內容',
   	completed boolean not null default false comment '是否完成'
   );
   
 */

public class TodoListDaoMySQL {

}

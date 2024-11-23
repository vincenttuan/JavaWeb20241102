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
   
   預設資料
   insert into todo(text, completed) value('Task 1', false);
   insert into todo(text, completed) value('Task 2', true);
   insert into todo(text) value('Task 3');
   
   查詢資料
   select id, text, completed from todo;
   
   修改資料
   update todo set text='Task A', completed=true where id=1;
   update todo set text='Task A' where id=1;
   update todo set completed=true where id=1;
   
   刪除資料
   delete from todo where id=1;
   
 */

public class TodoListDaoMySQL {

}

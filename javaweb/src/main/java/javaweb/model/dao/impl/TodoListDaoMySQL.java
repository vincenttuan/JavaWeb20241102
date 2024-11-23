package javaweb.model.dao.impl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javaweb.model.dao.TodoListDao;
import javaweb.model.entity.Todo;

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
   select count(*) as count from todo;
   
   
   修改資料
   update todo set text='Task A', completed=true where id=1;
   update todo set text='Task A' where id=1;
   update todo set completed=true where id=1;
   
   刪除資料
   delete from todo where id=1;
   
 */

public class TodoListDaoMySQL extends BaseDao implements TodoListDao {

	@Override
	public List<Todo> findAllTodos() {
		List<Todo> todos = new ArrayList<>();
		
		String sql = "select id, text, completed from todo";
		try(Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql)) {
			
			// 逐一尋訪 rs 的資料
			while (rs.next()) {
				Todo todo = new Todo();
				todo.setId(rs.getInt("id"));
				todo.setText(rs.getString("text"));
				todo.setCompleted(rs.getBoolean("completed"));
				// 注入到 todos
				todos.add(todo);
			}
			
		} catch(SQLException e) {
			e.printStackTrace();
		}
		
		return todos;
	}

	@Override
	public Todo getTodo(Integer id) {
		List<Todo> todos = findAllTodos();
		return todos.stream()
					.filter(todo -> todo.getId().equals(id))
					.findAny()
					.orElse(null); // 若找不到就得到 null
	}

	@Override
	public void addTodo(Todo todo) {
		String sql = "insert into todo(text, completed) value(?, ?)";
		try(PreparedStatement pstmt = conn.prepareStatement(sql)) {
			
			pstmt.setString(1, todo.getText());
			pstmt.setBoolean(2, todo.getCompleted());
			
			int rowcount = pstmt.executeUpdate(); // 執行更新
			System.out.println("新增 todo 筆數: " + rowcount);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void updateTodoComplete(Integer id, Boolean completed) {
		String sql = "update todo set completed=? where id=?";
		try(PreparedStatement pstmt = conn.prepareStatement(sql)) {
			
			pstmt.setBoolean(1, completed);
			pstmt.setInt(2, id);
			
			int rowcount = pstmt.executeUpdate();
			System.out.println("修改 completed 筆數: " + rowcount);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void updateTodoText(Integer id, String text) {
		String sql = "update todo set text=? where id=?";
		try(PreparedStatement pstmt = conn.prepareStatement(sql)) {
			
			pstmt.setString(1, text);
			pstmt.setInt(2, id);
			
			int rowcount = pstmt.executeUpdate();
			System.out.println("修改 Text 筆數: " + rowcount);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public void deleteTodo(Integer id) {
		// TODO Auto-generated method stub
		
	}
	
	
}

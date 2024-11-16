package javaweb.model.dao;

import java.util.List;

import javaweb.model.entity.Todo;

public interface TodoListDao {
	
	// 查詢所有 TodoList 資料
	List<Todo> findAllTodos();
	
	// 取得指定單筆 Todo 資料
	// 指定: 透過 id 來指定
	Todo getTodo(Integer id);
	
	// 新增 Todo 資料
	void addTodo(Todo todo);
	
	// 修改指定 Todo 完成與否
	void updateTodoComplete(Boolean completed);
	
	// 刪除指定 Todo 紀錄
	void deleteTodo(Integer id);
}

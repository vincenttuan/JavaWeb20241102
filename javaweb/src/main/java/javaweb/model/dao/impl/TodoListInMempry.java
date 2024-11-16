package javaweb.model.dao.impl;

import java.util.ArrayList;
import java.util.List;

import javaweb.model.dao.TodoListDao;
import javaweb.model.entity.Todo;

public class TodoListInMempry implements TodoListDao {
	
	// In-Memory 集合: 利用 ArrayList<Todo> 來模擬資料庫
	private static ArrayList<Todo> todos;
	// 類別變數初始區塊
	static {
		todos = new ArrayList<>();
		// 預設 3 筆 Todo 資料
		todos.add(new Todo(1, "看報表", false));
		todos.add(new Todo(2, "寫程式", true));
		todos.add(new Todo(3, "寫日誌", false));
	}
	
	@Override
	public List<Todo> findAllTodos() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Todo getTodo(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void addTodo(Todo todo) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateTodoComplete(Integer id, Boolean completed) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteTodo(Integer id) {
		// TODO Auto-generated method stub
		
	}

}

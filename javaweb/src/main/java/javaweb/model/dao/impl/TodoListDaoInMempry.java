package javaweb.model.dao.impl;

import java.util.ArrayList;
import java.util.List;

import javaweb.model.dao.TodoListDao;
import javaweb.model.entity.Todo;

public class TodoListDaoInMempry implements TodoListDao {
	
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
		return todos;
	}

	@Override
	public Todo getTodo(Integer id) {
		return todos.stream()
					.filter(todo -> todo.getId().equals(id))
					.findAny()
					.orElseGet(null);
	}

	@Override
	public void addTodo(Todo todo) {
		todos.add(todo);
	}

	@Override
	public void updateTodoComplete(Integer id, Boolean completed) {
		Todo todo = getTodo(id);
		if(todo == null) {
			return;
		}
		todo.setComppleted(completed);
	}
	
	@Override
	public void deleteTodo(Integer id) {
		Todo todo = getTodo(id);
		if(todo == null) {
			return;
		}
		todos.remove(todo);
		
	}

	@Override
	public void updateTodoText(Integer id, String text) {
		Todo todo = getTodo(id);
		if(todo == null) {
			return;
		}
		todo.setText(text);
	}

}

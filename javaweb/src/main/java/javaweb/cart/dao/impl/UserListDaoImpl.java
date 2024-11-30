package javaweb.cart.dao.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javaweb.cart.dao.UserListDAO;
import javaweb.cart.model.entity.User;

public class UserListDaoImpl implements UserListDAO {
	
	static Connection conn; // 資料庫連線
	
	static {
		try {
			// 1. 註冊 MySQL Driver
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			// 2. 建立連線
			String username = "root"; // MySQL 連線帳號
			String password = "12345678"; // MySQL 連線密碼
			String dbUrl = "jdbc:mysql://localhost:3306/web?serverTimezone=Asia/Taipei&useSSL=false"; // MySQL 連線位置
			conn = DriverManager.getConnection(dbUrl, username, password);
					
		} catch (Exception e) {
			e.printStackTrace(); // 若有錯誤則將錯誤訊息印出
		}
		
	}
	
	// 查詢所有使用者
	@Override
	public List<User> findAllUsers() {
		List<User> users = new ArrayList<User>(); // 用來存放所有使用者的容器
		
		String sql = "select id, username, hash_password, hash_salt, email, completed from user";
		try(Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql)) {
			// rs 裡面存放的是資料表的內容
			// 利用 rs.next() 逐筆取出資料
			while (rs.next()) {
				// 建立 User 物件來存放資料列每一個欄位的內容
				User user = new User();
				user.setId(rs.getInt("id"));
				user.setUsername(rs.getString("username"));
				user.setHashPassword(rs.getString("hash_password"));
				user.setHashSalt(rs.getString("hash_salt"));
				user.setEmail(rs.getString("email"));
				user.setCompleted(rs.getBoolean("completed"));
				// 注入到 users 集合中保存
				users.add(user);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return users;
	}

}

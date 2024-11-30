package javaweb.cart.dao.impl;

import java.sql.Connection;
import java.sql.DriverManager;
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
	
	@Override
	public List<User> findAllUsers() {
		// TODO Auto-generated method stub
		return null;
	}

}

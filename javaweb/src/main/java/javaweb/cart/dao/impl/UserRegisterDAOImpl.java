package javaweb.cart.dao.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.List;

import org.apache.catalina.User;

import javaweb.cart.dao.UserRegisterDAO;

public class UserRegisterDAOImpl implements UserRegisterDAO {
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

	@Override
	public User getUserById(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User getUserByName(String username) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int addUser(User user) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int updatePasswordById(Integer id, String newPassword) {
		// TODO Auto-generated method stub
		return 0;
	}

}

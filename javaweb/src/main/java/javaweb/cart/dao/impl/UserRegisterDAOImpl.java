package javaweb.cart.dao.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import javaweb.cart.dao.UserRegisterDAO;
import javaweb.cart.model.entity.User;

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
		String sql = "insert into user(username, hash_password, hash_salt, email) values(?, ?, ?, ?)";
		
		try(PreparedStatement pstmt = conn.prepareStatement(sql)) {
			
			pstmt.setString(1, user.getUsername());
			pstmt.setString(2, user.getHashPassword());
			pstmt.setString(3, user.getHashSalt());
			pstmt.setString(4, user.getEmail());
			
			int rowcount = pstmt.executeUpdate(); // 執行更新
			return rowcount; // 若 rowcount = 1 表示新增一筆成功
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return 0;
	}

	@Override
	public int updatePasswordById(Integer id, String newPassword) {
		// TODO Auto-generated method stub
		return 0;
	}
	
	// email 驗證成功並修改 completed = true
	@Override
	public int emailConfirmOK(String username) {
		String sql = "update user set completed = true where username = ?";
		try(PreparedStatement pstmt = conn.prepareStatement(sql)) {
			pstmt.setString(1, username); // 因為 username 資料表欄位是 varchar 型別所以要用 setString()
			
			int rowcount = pstmt.executeUpdate(); // 執行更新
			return rowcount;
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}

}

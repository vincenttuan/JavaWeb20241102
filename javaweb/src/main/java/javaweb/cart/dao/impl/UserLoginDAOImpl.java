package javaweb.cart.dao.impl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javaweb.cart.dao.UserLoginDAO;
import javaweb.cart.model.entity.User;

public class UserLoginDAOImpl extends BaseDAO implements UserLoginDAO {

	@Override
	public User findUserByName(String username) {
		String sql = "select id, username, hash_password, hash_salt, email, completed from user where username=?";
		try(PreparedStatement pstmt = conn.prepareStatement(sql)) {
			pstmt.setString(1, username);
			// 執行查詢
			try(ResultSet rs = pstmt.executeQuery()) {
				// 判斷是否有資料
				if(rs.next()) {
					// 建立 User 物件並注入欄位資料
					User user = new User();
					user.setId(rs.getInt("id"));
					user.setUsername(rs.getString("username"));
					user.setHashPassword(rs.getString("hash_password"));
					user.setHashSalt(rs.getString("hash_salt"));
					user.setEmail(rs.getString("email"));
					user.setCompleted(rs.getBoolean("completed"));
					
					return user;
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

}
package javaweb.model.dao.impl;

import java.sql.Connection;

// 用來讓不同的 xxxDao 透過 extends BaseDao 可以連接 MySQL
public class BaseDao {
	protected static Connection conn;
	
	static {
		String username = "root";
		String password = "12345678";
		String dbUrl = "jdbc:mysql://localhost:3306/web?serverTimezone=Asia/Taipei&characterEncoding=utf-8&useUnicode=true";
		
	}

}

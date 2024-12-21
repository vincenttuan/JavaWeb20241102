package javaweb.cart.dao.impl;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

import javaweb.cart.dao.OrderDAO;

public class OrderDAOImpl extends BaseDAO implements OrderDAO {

	@Override
	public Integer addOrder(Integer userId) {
		String sql = "insert into `order` (user_id) values(?)";
		Integer orderId = null; // 得到新增後的 order_id 資料
		
		// 因為後續要取得新增後自動生成的 order_id 所以要加上 Statement.RETURN_GENERATED_KEYS 參數設定
		try(PreparedStatement pstmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return orderId;
	}

	@Override
	public void addOrderItem(Integer orderId, Integer productId, Integer quantity) {
		// TODO Auto-generated method stub
		
	} 

	

}

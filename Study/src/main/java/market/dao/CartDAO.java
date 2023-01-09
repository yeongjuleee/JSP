package market.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.http.HttpSession;

import market.dto.Product;
import mvc.database.DBConnection;
import market.dto.CartDTO;

public class CartDAO {
	private Connection connection = null;
	private PreparedStatement preparedStatement = null;
	private ResultSet resultSet = null;
	
	public CartDAO() {
		connect();
	}
	
	void connect() {
		try {
			connection = DBConnection.getConnetion();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	// īƮ�� ������Ʈ �� ����(������) ���� 
	public boolean updateCart(Product product, String p_orderNum, String p_memberId) {
		// 1. ������ �ֹ���ȣ�� ���� productId�� ������ update, 
		// 2. ������ insert �ϵ���
		
		int flag = 0;
		String productId = product.getProductId();
		String sql = "SELECT cartId FROM cart WHERE p_orderNum = ? AND p_id = ?";
		
		try {
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, p_orderNum);
			preparedStatement.setString(2, productId);
			resultSet = preparedStatement.executeQuery();
			
			if(resultSet.next()) {
				int cartId = resultSet.getInt("cartId");
				sql = "UPDATE cart SET cnt = cnt + 1 WHERE cartId = ?";
				preparedStatement = connection.prepareStatement(sql);
				preparedStatement.setInt(1, cartId);
				flag = preparedStatement.executeUpdate();
			}
			else {
				sql = "INSERT INTO cart VALUES (null, ?, ?, ?, ?, ?, ?, ?, now())";
				preparedStatement = connection.prepareStatement(sql);
				preparedStatement.setString(1, p_memberId);
				preparedStatement.setString(2, p_orderNum);
				preparedStatement.setString(3, productId);
				preparedStatement.setString(4, product.getPname());
				// CartDAO�� ��ǰ�̸��� ���� X => DTO���� product�� �޾ƿ�.
				preparedStatement.setInt(5, product.getUnitPrice());
				preparedStatement.setInt(6, product.getUnitPrice() * 1);
				// ��ǰ ����(�Ұ�)  = �������ݿ� �� ������ŭ ���� -> unitPirce * 1 
				preparedStatement.setInt(7, 1);
				flag = preparedStatement.executeUpdate();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return flag == 1;
	}
	
	// ��ٱ��� ����Ʈ �����
	public ArrayList<CartDTO> getCartList(String p_orderNum) {
		ArrayList<CartDTO> cartArrayList = new ArrayList<>();
		String sql = "SELECT * FROM cart WHERE p_orderNum = ?";
		
		try {
			// p_orderNum �� �ֹ���ȣ�� �ϳ��̱⶧���� 1���� ������ ��.
			// ������ CartList�� �������̱� ������ while ������ ��������
			
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, p_orderNum);
			resultSet = preparedStatement.executeQuery();
			
			while(resultSet.next()) {
				// īƮ�� ���� ��ǰ�� ���� ���� �� �ֱ� (īƮ ������ȣ, ��ǰ�ڵ�, ��ǰ�̸�, ��ǰ ����, ��ǰ ����)
				CartDTO cart = new CartDTO();
				cart.setCartId(resultSet.getInt("cartId"));
				cart.setP_id(resultSet.getString("p_id"));
				cart.setP_name(resultSet.getString("p_name"));
				cart.setP_unitPrice(resultSet.getLong("p_unitPrice"));
				cart.setP_count(resultSet.getInt("p_count"));
				cartArrayList.add(cart);
			}
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		
		return cartArrayList;
	}
	
	public boolean updateCartBylogin(HttpSession session) { // cart ���õ� �����ͺ��̽��� �� ���⼭ ó���ϵ��� ��
		int flag = 0;
		String orderNo = session.getId();
		String id = (String)session.getAttribute("sessionId");
		
		// ���� �α��ο� ��� ��ǰ ������Ʈ
		String sql = "UPDATE cart SET p_orderNum = ? WHERE p_memberId = ?";
		try {
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, orderNo);
			preparedStatement.setString(2, id);
			flag = preparedStatement.executeUpdate();
			
			// �α��� ���� ���� ��ǰ ������Ʈ
			sql = "UPDATE cart SET p_memberId = ? WHERE p_orderNum = ?";
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1,  id);
			preparedStatement.setString(2,  orderNo);
			flag = preparedStatement.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return flag != 0;
		
	}
	
}

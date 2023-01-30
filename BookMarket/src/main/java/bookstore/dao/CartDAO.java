package bookstore.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.servlet.http.HttpSession;

import bookstore.dto.Book;
import mvc.database.DBConnection;
import bookstore.dto.CartDTO;

public class CartDAO {
	private Connection connection = null;
	private PreparedStatement preparedStatement = null;
	private Statement statement = null; 
	private ResultSet resultSet = null;
	
	public CartDAO() {
		connect();
	}
	
	void connect() {
		try {
			connection = DBConnection.getConnection();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	// īƮ�� ������Ʈ �� ����(������) ���� 
	public boolean updateCart(Book book, String b_orderNum, String b_memberId) {
		// 1. ������ �ֹ���ȣ�� ���� bookId�� ������ update, 
		// 2. ������ insert �ϵ���
		
		int flag = 0;
		String bookId = book.getBookId();
		String sql = "SELECT cartId FROM cart WHERE b_orderNum = ? AND b_id = ?";
		
		try {
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, b_orderNum);
			preparedStatement.setString(2, b_memberId);
			resultSet = preparedStatement.executeQuery();
			
			if(resultSet.next()) {
				int cartId = resultSet.getInt("cartId");
				sql = "UPDATE cart SET b_count = b_count + 1 WHERE cartId = ?";
				preparedStatement = connection.prepareStatement(sql);
				preparedStatement.setInt(1, cartId);
				flag = preparedStatement.executeUpdate();
			}
			else {
				sql = "INSERT INTO cart VALUES (null, ?, ?, ?, ?, ?, ?, ?, now())";
				preparedStatement = connection.prepareStatement(sql);
				preparedStatement.setString(1, b_memberId);
				preparedStatement.setString(2, b_orderNum);
				preparedStatement.setString(3, bookId);
				preparedStatement.setString(4, book.getName());
				// CartDAO�� ��ǰ�̸��� ���� X => DTO���� book�� �޾ƿ�.
				preparedStatement.setInt(5, book.getUnitPrice());
				preparedStatement.setInt(6, book.getUnitPrice() * 1);
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
	public ArrayList<CartDTO> getCartList(String b_orderNum) {
		ArrayList<CartDTO> cartArrayList = new ArrayList<>();
		String sql = "SELECT * FROM cart WHERE b_orderNum = ?";
		
		try {
			// b_orderNum �� �ֹ���ȣ�� �ϳ��̱⶧���� 1���� ������ ��.
			// ������ CartList�� �������̱� ������ while ������ ��������
			
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, b_orderNum);
			resultSet = preparedStatement.executeQuery();
			
			while(resultSet.next()) {
				// īƮ�� ���� ��ǰ�� ���� ���� �� �ֱ� (īƮ ������ȣ, ��ǰ�ڵ�, ��ǰ�̸�, ��ǰ ����, ��ǰ ����)
				CartDTO cart = new CartDTO();
				cart.setCartId(resultSet.getInt("cartId"));
				cart.setB_id(resultSet.getString("b_id"));
				cart.setB_name(resultSet.getString("b_name"));
				cart.setB_unitPrice(resultSet.getLong("b_unitPrice"));
				cart.setB_count(resultSet.getInt("b_count"));
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
		String sql = "UPDATE cart SET b_orderNum = ? WHERE b_memberId = ?";
		try {
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, orderNo);
			preparedStatement.setString(2, id);
			flag = preparedStatement.executeUpdate();
			
			// �α��� ���� ���� ��ǰ ������Ʈ
			sql = "UPDATE cart SET b_memberId = ? WHERE b_orderNum = ?";
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1,  id);
			preparedStatement.setString(2,  orderNo);
			flag = preparedStatement.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return flag != 0;
		
	}
	
	// ��ٱ��Ͽ��� ��ǰ�� ���� ����
	public boolean deleteCartById(String b_orderNum, int cartId) throws SQLException {
		int flag = 0;
		String sql = "SELECT * FROM cart WHERE b_orderNum = ? AND cartId = ?";
		preparedStatement = connection.prepareStatement(sql);
		preparedStatement.setString(1, b_orderNum);
		preparedStatement.setInt(2, cartId);
		resultSet = preparedStatement.executeQuery();
		
		if(resultSet.next()) {
			sql = "DELETE FROM cart WHERE cartId = ?";
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, cartId);
			flag = preparedStatement.executeUpdate();
		}
		return flag == 1;
	}
	
	// ��ٱ��Ͽ��� ��ü ��ǰ ����
	public boolean deleteCartAll (String b_orderNum) throws SQLException {
		int flag = 0;
		String sql = "DELETE FROM cart WHERE b_orderNum = ?";
		preparedStatement = connection.prepareStatement(sql);
		preparedStatement.setString(1, b_orderNum);
		flag = preparedStatement.executeUpdate();
		
		return flag == 1;
		
	}
	
	// ��ٱ��Ͽ��� ���� ��ǰ ����
	public boolean deleteCartBySelId(String b_orderNum, String chkdId) throws SQLException {
		int flag = 0;
		String sql = "DELETE FROM cart WHERE b_orderNum = '" + b_orderNum + "' AND cartId IN (" + chkdId + ")' ";
		statement = connection.createStatement();
		flag = statement.executeUpdate(sql);
		
		return flag != 0;
	}
}

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
	
	// 카트에 업데이트 할 내용(생성자) 선언 
	public boolean updateCart(Book book, String b_orderNum, String b_memberId) {
		// 1. 동일한 주문번호에 같은 bookId만 있으면 update, 
		// 2. 없으면 insert 하도록
		
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
				// CartDAO에 상품이름이 선언 X => DTO에서 book을 받아옴.
				preparedStatement.setInt(5, book.getUnitPrice());
				preparedStatement.setInt(6, book.getUnitPrice() * 1);
				// 상품 갯수(소계)  = 개별가격에 그 수량만큼 곱함 -> unitPirce * 1 
				preparedStatement.setInt(7, 1);
				flag = preparedStatement.executeUpdate();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return flag == 1;
	}
	
	// 장바구니 리스트 만들기
	public ArrayList<CartDTO> getCartList(String b_orderNum) {
		ArrayList<CartDTO> cartArrayList = new ArrayList<>();
		String sql = "SELECT * FROM cart WHERE b_orderNum = ?";
		
		try {
			// b_orderNum 은 주문번호가 하나이기때문에 1번만 받으면 됨.
			// 하지만 CartList는 여러개이기 때문에 while 문으로 돌려야함
			
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, b_orderNum);
			resultSet = preparedStatement.executeQuery();
			
			while(resultSet.next()) {
				// 카트에 담은 상품에 대한 정보 다 넣기 (카트 고유번호, 상품코드, 상품이름, 상품 가격, 상품 갯수)
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
	
	public boolean updateCartBylogin(HttpSession session) { // cart 관련된 데이터베이스는 다 여기서 처리하도록 함
		int flag = 0;
		String orderNo = session.getId();
		String id = (String)session.getAttribute("sessionId");
		
		// 이전 로그인에 담긴 상품 업데이트
		String sql = "UPDATE cart SET b_orderNum = ? WHERE b_memberId = ?";
		try {
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, orderNo);
			preparedStatement.setString(2, id);
			flag = preparedStatement.executeUpdate();
			
			// 로그인 전에 담은 상품 업데이트
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
	
	// 장바구니에서 상품을 개별 삭제
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
	
	// 장바구니에서 전체 상품 삭제
	public boolean deleteCartAll (String b_orderNum) throws SQLException {
		int flag = 0;
		String sql = "DELETE FROM cart WHERE b_orderNum = ?";
		preparedStatement = connection.prepareStatement(sql);
		preparedStatement.setString(1, b_orderNum);
		flag = preparedStatement.executeUpdate();
		
		return flag == 1;
		
	}
	
	// 장바구니에서 선택 상품 삭제
	public boolean deleteCartBySelId(String b_orderNum, String chkdId) throws SQLException {
		int flag = 0;
		String sql = "DELETE FROM cart WHERE b_orderNum = '" + b_orderNum + "' AND cartId IN (" + chkdId + ")' ";
		statement = connection.createStatement();
		flag = statement.executeUpdate(sql);
		
		return flag != 0;
	}
}

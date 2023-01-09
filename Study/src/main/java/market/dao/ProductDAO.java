package market.dao;

import java.sql.*;

import market.dto.Product;
import mvc.database.DBConnection;

public class ProductDAO {
	private Connection connection = null;
	private PreparedStatement preparedStatement = null;
	private ResultSet resultSet = null;
	
	// DB 연결 메소드 
	void connect() {
		try {
			connection = DBConnection.getConnetion();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public ProductDAO() {
		connect();
	}
	
	public Product getProductById(String id) {
		// 전달된 id에 해당하는 상품을 DB에서 조회
		// 1. 있는 경우 => 객체에 담아서 전달
		// 2. 없는 경우 => null 전달
		Product product = null;	// 초기값 설정
		String sql = "SELECT * FROM product WHERE p_id = ?";
		
		try {
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, id);
			resultSet = preparedStatement.executeQuery();
			
			if(resultSet.next()) {
				product = new Product(resultSet.getString("p_id"),
							resultSet.getString("p_name"), resultSet.getInt("p_unitPrice"));
				product.setDescription(resultSet.getString("p_description"));
				product.setCategory(resultSet.getString("p_category"));
				product.setManufacturer(resultSet.getString("p_manufacturer"));
				product.setUnitsInStock(resultSet.getInt("p_unitsInStock"));
				product.setCondition(resultSet.getString("p_condition"));
				product.setFilename(resultSet.getString("p_fileName"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return product;
	}
	
}

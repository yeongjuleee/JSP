package bookstore.dao;

import java.sql.*;

import bookstore.dto.Book;
import mvc.database.DBConnection;

public class BookDAO {
	private Connection connection = null;
	private PreparedStatement preparedStatement = null;
	private ResultSet resultSet = null;
	
	// DB 연결 메소드 
	void connect() {
		try {
			connection = DBConnection.getConnection();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public BookDAO() {
		connect();
	}
	
	public Book getBookById(String id) {
		// 전달된 id에 해당하는 상품을 DB에서 조회
		// 1. 있는 경우 => 객체에 담아서 전달
		// 2. 없는 경우 => null 전달
		Book book = null;	// 초기값 설정
		String sql = "SELECT * FROM bookstore WHERE b_id = ?";
		
		try {
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, id);
			resultSet = preparedStatement.executeQuery();
			
			if(resultSet.next()) {
				book = new Book(resultSet.getString("b_id"),
							resultSet.getString("b_name"), resultSet.getInt("b_unitPrice"));
				book.setAuthor(resultSet.getString("b_author"));
				book.setDescription(resultSet.getString("b_description"));
				book.setPublisher(resultSet.getString("b_publisher"));
				book.setCategory(resultSet.getString("b_category"));
				book.setUnitsInStock(resultSet.getInt("b_unitsInStock"));
				book.setTotallPages(resultSet.getLong("b_totalPages"));
				book.setReleaseDate(resultSet.getString("b_releaseDate"));
				book.setCondition(resultSet.getString("b_condition"));
				book.setFilename(resultSet.getString("b_fileName"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return book;
	}
	
}

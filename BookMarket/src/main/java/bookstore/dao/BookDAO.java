package bookstore.dao;

import java.sql.*;

import bookstore.dto.Book;
import mvc.database.DBConnection;

public class BookDAO {
	private Connection connection = null;
	private PreparedStatement preparedStatement = null;
	private ResultSet resultSet = null;
	
	// DB ���� �޼ҵ� 
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
		// ���޵� id�� �ش��ϴ� ��ǰ�� DB���� ��ȸ
		// 1. �ִ� ��� => ��ü�� ��Ƽ� ����
		// 2. ���� ��� => null ����
		Book book = null;	// �ʱⰪ ����
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

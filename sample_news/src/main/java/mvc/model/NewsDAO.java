package mvc.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class NewsDAO {
	final String JDBC_DRIVER = "org.mariadb.jdbc.Driver";
	final String JDBC_URL = "jdbc:mariadb://localhost:3308/sample_news";
	final String JDBC_USER = "root";
	final String JDBC_PASSWORD = "0732";
	
	public Connection open() {
		// DB ������ �������� �޼ҵ� 
		// ������ �޼ҵ帶�� ������ ����� �����ϴ� ����
		
		Connection connection = null;
		try {
			Class.forName(JDBC_DRIVER);
			connection = DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASSWORD);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return connection;
	}
	
	public void addNews(News news) throws Exception {
		// ������ �߰��ϴ� �޼ҵ�
		Connection connection = open();
		
		String sql = "INSERT INTO news (title, img, date, content, name) VALUES (?, ?, now(), ?, ?)"; 
		PreparedStatement preparedStatement = connection.prepareStatement(sql);
		
		// try-with-resource ����� ����� �κ����� �ش� ���ҽ��� �ڵ����� close
		try(connection; preparedStatement) {
			preparedStatement.setString(1, news.getTitle());
			preparedStatement.setString(2, news.getImg());
			preparedStatement.setString(3, news.getContent());
			preparedStatement.setString(4, news.getName());
			preparedStatement.executeUpdate();
		}
	}
	
	public List<News> getAll() throws Exception {
		// ���� ��� ��� ��ü�� ������ ���� ���� �޼ҵ�
		
		Connection connection = open();
		List<News> newsList = new ArrayList<>();
		
		String sql = "SELECT aid, title, img, date, content, name FROM news";
		PreparedStatement preparedStatement = connection.prepareStatement(sql);
		ResultSet resultSet = preparedStatement.executeQuery();
		
		try(connection; preparedStatement; resultSet) {
			while (resultSet.next()) {
				News news = new News();
				news.setAid(resultSet.getInt("aid"));
				news.setTitle(resultSet.getString("title"));
				news.setImg(resultSet.getString("img"));
				news.setDate(resultSet.getString("date"));
				news.setContent(resultSet.getString("content"));
				news.setName(resultSet.getString("name"));
				//news.setName(sql);
				newsList.add(news);
			}
		}
		return newsList;
	}
	
	public News getNews(int aid) throws Exception {
		// ���� ��Ͽ��� ������ �������� �� Ư�� ���� ����� ���� ������ �����ֱ� ���� �޼ҵ�
		Connection connection = open();
		
		News news = new News();
		String sql = "SELECT aid, title, img, date, content, name FROM news WHERE aid = ?";
		PreparedStatement preparedStatement = connection.prepareStatement(sql);
		preparedStatement.setInt(1, aid);
		ResultSet resultSet = preparedStatement.executeQuery();
		resultSet.next();
		
		try (connection; preparedStatement; resultSet) {
			news.setAid(resultSet.getInt("aid"));
			news.setTitle(resultSet.getString("title"));
			news.setImg(resultSet.getString("img"));
			news.setDate(resultSet.getString("date"));
			news.setContent(resultSet.getString("content"));
			news.setName(resultSet.getString("name"));
			return news;
		}
		
	}
	
	public void delNews(int aid) throws Exception {
		// ���� ����
		Connection connection = open();
		
		String sql = "DELETE FROM news WHERE aid = ?";
		PreparedStatement preparedStatement = connection.prepareStatement(sql);
		
		try(connection; preparedStatement) {
			preparedStatement.setInt(1, aid);
			
			// ������ ���� ��簡 ���� ���
			if (preparedStatement.executeUpdate() == 0) {
				throw new SQLException("DB����");
			}
		}
	}
}

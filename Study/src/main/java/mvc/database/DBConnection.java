package mvc.database;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.DriverManager;

public class DBConnection {

		public static Connection getConnection() throws SQLException, ClassNotFoundException {
			
			Connection conn = null;
			
			String url = "jdbc:mariadb://localhost:3308/market";
			String user = "root";
			String password = "0732";
			
			Class.forName("org.mariadb.jdbc.Driver");
			conn = DriverManager.getConnection(url, user, password);
			
			return conn;
			
		}

}
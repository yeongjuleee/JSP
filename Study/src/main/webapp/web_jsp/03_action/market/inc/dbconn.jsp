<%@ page import="java.sql.*"%>
<%
	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	
	String url = "jdbc:mariadb://localhost:3308/market";
	String user = "root";
	String password = "0732";
	
	Class.forName("org.mariadb.jdbc.Driver");
	conn = DriverManager.getConnection(url, user, password);
%>
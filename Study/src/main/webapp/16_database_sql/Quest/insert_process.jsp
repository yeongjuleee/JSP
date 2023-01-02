<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="dbconn.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	 
	 <%
	 	request.setCharacterEncoding("utf-8");
	 
	 	String num = request.getParameter("num");
	 	String depart = request.getParameter("depart");
	 	String name = request.getParameter("name");
	 	String address = request.getParameter("address");
	 	String phone = request.getParameter("phone");
	 	
	 	PreparedStatement pstmt = null;
	 	
	 	try {
	 		String sql = "insert into student (num, depart, name, address, phone) values (?,?,?,?,?)";
	 		//String sql2 = "INSERT INTO student(num, depart, name, address, phone) VALUES ('"
	 		//		+ num + "', '" + depart + "', '" + name + "', '" + address + "', '" + phone + "')";
	 		//out.print(sql2);
	 		
	 		pstmt = conn.prepareStatement(sql);
	 		
	 		pstmt.setString (1, num);
	 		pstmt.setString (2, depart);
	 		pstmt.setString (3, name);
	 		pstmt.setString (4, address);
	 		pstmt.setString (5, phone);
	 		
	 		pstmt.executeUpdate();
	 		
	 		out.println("Member 테이블 삽입이 성공했습니다.");
	 	} catch (SQLException ex) {
	 		out.println("Member 테이블 삽입이 실패했습니다 <br>");
	 	} finally {
	 		if (pstmt != null)
	 			pstmt.close();
	 		if(conn != null)
	 			conn.close();
	 	}
	 %>
</body>
</html>
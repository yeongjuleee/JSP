<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.Enumeration" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Welcome</title>
</head>
<body>
	<form action="session_out.jsp" method="post">
		<input type="submit" value="로그아웃">
	</form>
	
	<%
		String id = null;		
		// 기본, id = null. 
		id = (String)session.getAttribute("userID");
		// 설정한 setAttribute("userID") 값을 받아서(getAttribute) id에 저장. 
		// 이때 String 으로 형변환!! 

		if (id == null) {
			response.sendRedirect("session.jsp");
		}
		else {
			out.println(id + "님 반갑습니다.");
		}
	%>
</body>
</html>
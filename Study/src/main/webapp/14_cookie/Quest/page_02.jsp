<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Page_02</title>
</head>
<body>
	<h3>회원 전용 페이지입니다.</h3>
	<form action="logout.jsp" method="post">
		<input type="submit" value="로그아웃">
	</form>
	
	<%
		String id = null;
		id = (String)session.getAttribute("userID");
		
		if (id == null) {
			response.sendRedirect("login.jsp");
		}
		
	%>
</body>
</html>
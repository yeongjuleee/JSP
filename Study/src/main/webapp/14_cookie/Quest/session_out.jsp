<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Session out</title>
</head>
<body>
	<%
		session.invalidate(); // 저장된 모든 세션 속성을 삭제함
		
		response.sendRedirect("session.jsp");
	%>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<% 
		// sendRedirect(String url) : 설정한 URL 페이지로 강제 이동
		response.sendRedirect("https://www.google.com/");
	%>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Form Processing</title>
</head>
<body>
	<%
		request.setCharacterEncoding("UTF-8");
	
		String name = request.getParameter("name");
		String zipcode = request.getParameter("zipcode");
		String email = request.getParameter("email");
	%>
	
	<p>이   름 : <%=name%></p>
	<p>주   소 : <%=zipcode%></p>
	<p>이 메 일 : <%=email%></p>
</body>
</html>
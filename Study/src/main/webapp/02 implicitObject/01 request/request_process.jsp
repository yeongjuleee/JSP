<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Implicit Object : request</title>
</head>
<body>
	<% 
		// 타입 변수 = 메소드
		String info = request.getQueryString();
	%>
	<p>전송된 요청 파라미터 : <b><%=info%></b>
</body>
</html>
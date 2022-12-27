<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Scripting Tag expression</title>
</head>
<body>
	<h3>expression, 표현문</h3>
	<p>출력할 때 사용한다고 생각하자. 대충 out.println 대신 사용~</p>
	
	<%-- 표현문 태그 사용 예 --%>
	<% 
		// 메소드 실행할 때에만 증가함
		int count = 0;
	%>
	
	Page Count is
	<%-- 지역변수 count 1 증가시킴 --%>
	<%= ++count %>
	<%-- out.println 을 사용하던가 <%= %> 을 사용하던가 --%> 
</body>
</html>
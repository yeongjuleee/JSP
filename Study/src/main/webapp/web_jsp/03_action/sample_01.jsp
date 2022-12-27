<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<%
		int num1 = 5;
	%>
	<%@include file="saple_01_include.jsp"%>
	<br>
	<%
		out.println(num1 * num2);
	%>
</body>
</html>
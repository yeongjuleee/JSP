<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Implicit Object : out </title>
</head>
<body>
	<%
		// jaca.util.Calendar.getInstance().getTime() 한줄로 편하게 사용 가능
		out.println("오늘의 날짜 및 시각 " + "<br>");
		out.println(java.util.Calendar.getInstance().getTime());
		out.println();
		
		out.println("<br>" + "오늘의 날짜 및 시각 " + "<br>");
		java.util.Calendar today = java.util.Calendar.getInstance();
		out.println(today.getTime());
	%>
</body>
</html>
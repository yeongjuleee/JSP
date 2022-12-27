<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Scripting Tag scriptlet</title>
</head>
<body>
	<h3>스크립틀릿 태그를 이용하여 다음 조건에 맞게 JSP 애플리케이션을 만들고 실행 결과를 확인하라</h3>
	<p>1. 스크립틀릿 태그를 이용하여 java.util.Date 형 지역 변수에 현재 날짜를 저장</p>
	<p>2. 현재 날짜 값을 출력</p>
	
	<% java.util.Date today = new java.util.Date();
		out.println(today);
	
	%>
	
	
</body>
</html>
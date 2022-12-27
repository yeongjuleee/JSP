<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Implicit Object response : 응답 HTTP 헤더 관련 setIntHeader(Refresh)</title>
</head>
<body>
	<h3>이 페이지는 5초마다 새로고침 됩니다.</h3>
	<p>
		response 내장 객체로 5초마다 JSP 페이지 갱신하기 <br> 
		1. 5초마다 JSP 페이지가 갱신되도록 
		   response 내장 객체의 setIntHeader() 메소드를 작성.<br><br>
		2.5초마다 JSP 페이지가 갱신된 시간을 출력하도록 표현문 태그 작성
	</p>

	<%
	response.setIntHeader("Refresh", 5);
	%>

	<p><%=(new java.util.Date())%></p>
</body>
</html>
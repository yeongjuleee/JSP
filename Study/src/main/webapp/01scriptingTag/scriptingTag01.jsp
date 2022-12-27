<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Scripting Tag declaration</title>
</head>
<body>
	<h2>선언문 태그</h2>
	<p></p>

	<%--선언문 태그 사용 예: 전역변수 선언 --%>
	<%! 
		int count = 0; // 전역변수 count를 0 으로 초기화
	%>
	Page Count is
	<%
		out.println(++count); // 전역 변수 1 증가. 새로 고침을 하면 숫자가 증가
	%>
</body>
</html>
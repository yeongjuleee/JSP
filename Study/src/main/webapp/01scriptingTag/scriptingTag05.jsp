<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Scripting Tag </title>
</head>
<body>
	<%-- 선언문 태그에 전역 메소드 사용하기 --%>
	<%-- 전역 메소드 sum()을 선언하기 위해 선언문 태그를 작성 --%>
	<%! int sum(int a, int b) {
		return a + b;	
	}%>

	<%-- 결과 값 출력을 위해 스크립틀릿 태그를 작성 --%>
	<% 
		out.println("2 + 3 = " + sum(2, 3)); // 선언문 태그에 선언된 전역 메소드
	%>
</body>
</html>
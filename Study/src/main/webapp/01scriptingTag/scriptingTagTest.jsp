<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Scripting Tag Test</title>
</head>
<body>
	<h4>문제</h4>
	<p>1. 선언문 태그에 문자형 전역 변수를 선언하여 'Hello, Java Server Pages'를 저장</p>
	<p>2. 문자형 변수 값을 반환하는 전역 메소드 getString()을 작성</p>
	<p>3. getString() 메소드를 호출하여 문자형 변수 값을 출력</p>
	
	
	<%!
		// 문자형 전역 변수를 선언하여 'Hello, Java Server Pages'를 저장
		String a = "Hello, Java Server Pages";
	
		// 문자형 변수 값을 반환하는 전역 메소드 getString()을 작성
		public String getString() {
			return a;
		}
	%>
	
	<%= getString() %>
	
	
</body>
</html>
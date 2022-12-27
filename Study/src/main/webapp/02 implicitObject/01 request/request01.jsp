<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Implicit Object request</title>
</head>
<body>
	<h3>request 내장 객체로 폼 페이지에서 아이디와 비밀번호를 전송받아 출력하기</h3>
	<p> 1. 폼 페이지에서 입력한 한글을 처리하도록 <br>
		   request 내장 객체의 setCharacterEncoding() 메소드에 문자 인코딩 유형 utf-8로 작성<br><br>
		2. 입력된 아이디와 비밀번호를 폼 문으로부터 전송 받도록<br>
		   request 내장 객체의 getParameter() 메소드 작성<br><br>
		3. 폼 문으로부터 전송받은 아이디와 비밀번호를 출력하도록 표현문 태그 작성<br><br> </p>
		
	<%
		request.setCharacterEncoding("utf-8");
		String userid = request.getParameter("id");
		String password = request.getParameter("passwd");
	%>
	<p> 아 이 디 : <%=userid%></p>
	<p> 비밀번호 : <%=password%></p>
</body>
</html>
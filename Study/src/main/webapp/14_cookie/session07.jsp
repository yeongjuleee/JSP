<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Session</title>
</head>
<body>
	<%--
		세션 유효 시간을 가져와 출력하기
		1.  세션에 설정된 유효 시간을 가져오도록 session 내장 객체의 getMaxInactiveInterval() 메소드를 작성하고
			유효 시간을 출력하도록 작성
		2.  세션 유효 시간을 60 * 60초로 설정하도록 
			session 내장 객체의 setMaxInactiveInterval() 메소드 작성
		3.  세션에 설정된 유효 시간을 가져오도록 session 내장 객체의 
			getMaxInactiveInterval() 메소드를 작성하고, 유효시간을 출력하도록 작성
	 --%>
	 
	 <p><h4>----------- 세션 유효 시간 변경 전 -----------</h4>
	 <%
	 	int time = session.getMaxInactiveInterval() / 60;
	 	// 30분
	 
	 	out.println("세션 유효 시간 : " + time + "분 <br>");
	 %>
	 
 	 <p><h4>----------- 세션 유효 시간 변경 후 -----------</h4>
 	 <%
 	 	session.setMaxInactiveInterval(60 * 60);
 	 	time = session.getMaxInactiveInterval() / 60;
 	 	// 60분
 	 	
 	 	out.println("세션 유효 시간 : " + time + "분 <br>");
 	 %>
</body>
</html>
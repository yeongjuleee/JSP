<%@page import="java.util.Enumeration" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Implicit Object request</title>
</head>
<body>
	<h3>request 내장 객체로 모든 HTTP 헤더 정보 값 출력하기</h3>
	<p> 1. 모든 헤더 이름을 가져오도록 request 내장 객체의 getHeaderNames() 메소드를 호출하고, <br>
		   이를 모두 저장하도록 Enumeration 객체 타입의 변수 en을 작성. <br><br>
		2. Enumeration 객체 타입 변수 en의 hasMoreElements() 메소드를 통해 <br>
		   저장된 헤더 이름이 있을 때까지 반복하도록 while문 작성 <br><br>
		3. 현재 헤더 이름을 가져오도록 Enumeration 객체 타입 변수 en의 nextElement() 메소드를 작성<br><br>
		4. 설정된 헤더 이름의 값을 가져오도록 request 내장 객체의 getHeader() 메소드를 작성<br><br>
		5. 현재 헤더 이름과 값을 출력하도록 표현문 태그를 작성 <br><br>
		
		예) <br>
		user-agent : 사용자의 브라우저 정보 <br>
		referer : 현재 페이지로 이동해오기 바로 전 페이지의 주소<br></p>
	
	<hr>
	
	<%
		Enumeration en = request.getHeaderNames();
		while (en.hasMoreElements()) {
			String headerName = (String) en.nextElement();
			String headerValue = request.getHeader(headerName);
		
	%>
	<%=headerName %> : <%=headerValue%><br>
	<%
	}
	%>
</body>
</html>
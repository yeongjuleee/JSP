<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page errorPage="errorPage_error.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Exception</title>
</head>
<body>
	<%--
		page 디렉티브 태그에 errorPage 속성을 이용하여 오류 페이지 호출하기
		1)  JSP 페이지가  실행되는 도중에 오류가 발생하면 오류 페이지를 호출하도록 
			page 디렉티브 태그에 errorPage 속성을 작성
		2)  toUpperCase() 메소드는 파라미터 값을 대문자로 변환하여 출력
			이때 파라미터 name이 존재하지 X 오류 발생
	 --%>
	 
	 name 파라미터 : <%=request.getParameter("name").toUpperCase() %>
</body>
</html>
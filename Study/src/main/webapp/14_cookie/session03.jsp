<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.Enumeration" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Session</title>
</head>
<body>
	<%--
		세션에 저장된 모든 세션 속성 이름과 속성 값을 가져와 출력하기
		1.  세션에 저장된 모든 세션 속성 이름을 가져오도록 session 내장 객체의 getAttribute() 메소드 작성
		2.  Enumeration 객체의 hasMoreElemets() 메소드를 통하여 
			저장된 세션 속성의 이름이 있을 때까지 반복하도록 while문 작성
		3.  세션 속성 이름을 가져오도록 Enumeration 객체의 nextElement() 메소드 작성
		4.  세션 속성 이름의 속성 값을 가져오도록 session 내장 객체의 getAttribute() 메소드 작성
	 --%>
	 
	 <%
	 	String name;
	 	String value;
	 	
	 	Enumeration en = session.getAttributeNames();
	 	// getParmeter의 경우 없는 값을 부르면 에러가 발생하지만, 
	 	// Enumeration의 경우 없는 값을 불러도 null이 되고 에러 발생X
	 	
	 	int i = 0;
	 	
	 	while (en.hasMoreElements()) {
	 		i++;
	 		name = en.nextElement().toString();
	 		value = session.getAttribute(name).toString();
	 		out.println("설정된 세션의 속성 이름 [ " + i + " ] : " + name + "<br>");
	 		out.println("설정된 세션의 속성 값 [ " + i + " ] : " + value + "<br>");
	 	}
	 %>
</body>
</html>
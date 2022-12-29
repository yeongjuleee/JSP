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
		세션에 저장된 세션 속성 삭제하지
		1. 세션에 저장된 세션 속성 이름 userID를 삭제하도록 session 내장 객체의 removeAttribute() 메소드를 작성
	 --%>
	 
	 <%
	 	String user_id = (String) session.getAttribute("userID");
	 	String user_pw = (String) session.getAttribute("userPW");
	 	out.println("설정된 세션 userID : " + user_id + "<br>");
	 	out.println("설정된 세션 userPW : " + user_pw + "<br>");
	 	
	 	session.removeAttribute("userID");
	 %>
	 <p><h4>-----------세션을 삭제한 후-----------</h4>
	 <%
	 	user_id = (String)session.getAttribute("userID");
	 	user_pw = (String) session.getAttribute("userPW");
	 	out.println("설정된 세션 userID : " + user_id + "<br>");
	 	out.println("설정된 세션 userPW : " + user_pw + "<br>");
	 %>
</body>
</html>
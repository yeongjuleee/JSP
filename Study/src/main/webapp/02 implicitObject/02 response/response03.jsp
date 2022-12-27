<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Implicit Object : response 응답 콘텐츠 관련 메소드 sendError() </title>
</head>
<body>
	<h3>response 내장 객체로 오류 응답 코드와 오류 메시지 보내기</h3>
	<p> 1. 웹 브라우저에 응답할 오류로 404 코드 및 오류 메시지를 출력하도록 <br>
	response 내장 객체의 sendError() 메소드를 작성</p>
	
	<%
		response.sendError(404, "요청 페이지를 찾을 수 없습니다.");
	%>
	
</body>
</html>
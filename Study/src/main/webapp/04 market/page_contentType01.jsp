<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Directives Tag</title>
</head>
<body>
	<%-- 
		page 디렉티브 태그에 콘텐츠 유형을 마이크로 소프트 워드 문서(application/msword)로 설정하기
		1. 콘텐츠 유형을 application/msword로 설정하도록 page 디렉티브 태그의 contentType 속성을 삭제
	 --%>
	 
	 Today is: <%= new java.util.Date() %>
</body>
</html>
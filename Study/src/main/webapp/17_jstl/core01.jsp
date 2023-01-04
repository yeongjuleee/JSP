<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%--
		웹 브라우저 헤더를 변수에 저장하고 설정한 변수를 삭제하기
		1. browser 변수에 변수 값으로 header['User-Agent']를 설정하도록 <c:set> 태그 작성
		2. browser 변수 값을 출력하도록 <c:out> 태그를 작성
		3. browser 변수 값을 삭제하도록 <c:remove> 태그 작성
		4. browser 변수 값을 출력하도록 <c:out> 태그 작성
	 --%>
	 
	 browser 변수 값 설정
	 <c:set var="browser" value="${header['User-Agent']}" />
	 <br>
	 <c:out value="${browser }" />
	 <p>browser 변수 값 제거 후
	 <c:remove var="browser" />
	 <c:out value="${browser}" />
</body>
</html>
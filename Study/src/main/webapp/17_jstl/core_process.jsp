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
	<%
		request.setCharacterEncoding("utf-8");
		
		String score = request.getParameter("score");
	%>
	
	<c:set var="score" value="<%=score%>" />
	 점수 <c:out value="${score }" /> 은
	
	<br>
	<c:choose>
		<%-- c:choose = switch문 --%>
		<c:when test="${score >= 90 }" > A학점입니다.</c:when>
		<c:when test="${score >= 80 }" > B학점입니다.</c:when>
		<c:when test="${score >= 70 }" > C학점입니다.</c:when>
		<c:when test="${score >= 60 }" > D학점입니다.</c:when>
		<c:otherwise>F학점입니다.</c:otherwise>
		<%--  c:otherwise = default 값과 같음 --%>
	</c:choose>
</body>
</html>
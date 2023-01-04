<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="edu.BookBean" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Title</title>
</head>
<body>
	<!-- JSP 책 확인해서 JSTL 보기!!! 
		 c:set 변수명 잡기 
		 c:out 값을 출력
	-->
	
	<c:set var="name" value="Amy" />
	<c:out value="${name}" /> <br>
	
	<c:remove var="name" />
	<c:out value="${name}" /><br>
	
	<%
		BookBean bookBean = new BookBean("The Secret", "Byrne, Rhonda", "Atria Books");
		request.setAttribute("bookOne", bookBean);
	%>
	
	<c:set var="title" value="${bookOne.title }" />
	<c:out value="${title}" /><br>
	
	<c:set var="author" value="<%=bookBean.getAuthor()%>" />
	<c:out value="${author }" /><br>
	
	<hr>
	
	<c:set var="name">Tobey</c:set>
    <c:out value="${name}"/><br>
   
   <%
   		BookBean bookBean1 = new BookBean("The Last Lecture", "Randy Pausch", "hyperion");
   		request.setAttribute("bookTwo", bookBean1);
   %>
   
   <c:set var="title" value="${bookTwo.title}"/>
   <c:out value = "${title}"/><br>
   
   <c:set var="author" value="<%=bookBean1.getAuthor() %>"/>
   <c:out value = "${author}"/><br>
	
</body>
</html>
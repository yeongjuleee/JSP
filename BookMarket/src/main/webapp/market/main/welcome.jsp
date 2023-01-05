<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href ="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css
">
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<%!String greeting = "도서 웹 쇼핑몰" ;
	String tagline = "Welcome to Web Market!";%>
	<div class="jumbotron">
		<div class="container">
			<h1><%=greeting %></h1>
		</div>
	</div>
	<div class="container">
		<div class="text-center">
			<h3><%=tagline %></h3>
		</div>
	</div>
	
 <%@ include file="../inc/footer.jsp" %>
	
</body>
</html>
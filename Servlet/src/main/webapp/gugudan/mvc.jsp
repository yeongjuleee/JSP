<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
<head>
<meta charset="UTF-8">
<title>구구단</title>
</head>
<body>
   <!-- 
   뷰 구현 : mvc.jsp
    -->
	 <form method="post" action="GugudanController">
	 	<p>구구단 : <input type="text" name="n" size="10">
	 	<input type="submit" value="제출">
	 </form>
</body>
</html>
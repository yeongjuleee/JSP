<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Database SQL_insert</title>
</head>
<body>
	<form method="post" action="insert_process.jsp">
		<p> 학    번 : <input type="text" name="num">
		<p> 학    과 : <input type="text" name="depart">
		<p> 이    름 : <input type="text" name="name">
		<p> 주    소 : <input type="text" name="address">
		<p> 연 락 처 : <input type="text" name="phone">
		<p> <input type="submit" value="전송">
	</form>
</body>
</html>
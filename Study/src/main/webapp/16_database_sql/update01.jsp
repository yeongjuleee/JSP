<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>DataBase_Sql Update</title>
</head>
<body>
	<h4>아이디, 비밀번호 인증을 이용한 이름 수정</h4>
	<form method="post" action="update01_process.jsp">
		<p> 기 존 아 이 디 : <input type="text" name="id">
		<p> 기 존 비밀 번호 : <input type="password" name="passwd">
		<p> 수 정 할 이 름 : <input type="text" name="name">
		<p> <input type="submit" value="전송">
	</form>
</body>
</html>
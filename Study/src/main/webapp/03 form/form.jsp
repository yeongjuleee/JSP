<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Form Processing</title>
</head>
<body>
	<h2>회원가입</h2>
	<form action="#" name="member" method="post">
		<p> 아 이 디 : <input type="text" name="id"><input type="button" value="아이디 중복 검사"></p>
		<p> 비밀 번호 : <input type="password" name="passwd"></p>
		<p> 이    름 : <input type="text" name="name"></p>
		<p> 연 락 처 : <input type="text" maxlength="4" size="4" name="phone1">
		- <input type="text" maxlength="4" size="4" name="phone2"> - <input type="text" maxlength="4" size="4" name="phone3"></p>
		<p> 성   별 : <input type="radio" name="sex" value="남성" checked>남성
					<input type="radio" name="sex" value="여성">여성</p>
		<p> 취   미 : 독서<input type="checkbox" name="hobby1" checked>
					운동<input type="checkbox" name="hobby2">
					영화<input type="checkbox" name="hobby3"></p>
		<p> <input type="submit" value="가입하기">
			<input type="reset" value="다시쓰기"></p>
	</form>
</body>
</html>
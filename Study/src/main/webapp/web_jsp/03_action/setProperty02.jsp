<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Action Tag : setProperty</title>
</head>
<body>
	<%-- 
	getProperty 액션 태그에 JavaBeans Person을 이용하여 아이디와 이름을 전달받아 출력하기
	1. javaBeans로 Person 클래스를 사용하도록 useBean 액션 태그를 작성
	2. useBean 액션 태그의 id 속성 값을 통해 Person의 property id와 name에 값을 저장하도록 setProperty 액션 태그를 작성
	3. useBean 액션 태그의 id 속성 값을 통해 Person의 property id와 name에 값을 가져와 출력하도록 getProperty 액션 태그를 작성
	 --%>

	<jsp:useBean id ="person" class="user.Person" scope="request" />
	<jsp:setProperty name="person" property="id" value="20000909" />
	<jsp:setProperty name="person" property="name" value="김준규" />
	<p>아이디: <jsp:getProperty name="person" property="id" /> </p>
	<p>이 름: <jsp:getProperty name="person" property="name" /> </p>
</body>
</html>
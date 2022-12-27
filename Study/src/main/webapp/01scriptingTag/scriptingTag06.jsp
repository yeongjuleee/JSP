<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Scripting Tag scriptlet</title>
</head>
<body>
	<%-- 스크립틀릿 태그에 0부터 10까지의 짝수 출력하기 --%>
	<%
		for(int i = 1; i <= 10; i++) {
			if (i % 2 == 0)
				out.println(i + "<br>");
		}
	%>
</body>
</html>
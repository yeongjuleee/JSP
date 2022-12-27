<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Scripting Tag</title>
</head>
<body>
	<h1>인코딩 설정이 UTF-8로 되어있음</h1>
	<h2>Scripting Tag</h2>
	<%-- 주석 태그
	JSP 주석 태그 comments tag : JSP 웹 컨테이너가 무시하는 텍스트를 표시.
	주석 태그는 JSP 페이지의 일부를 주석 처리하여 숨길 때 유용 
	주석은 프로그램의 실행에는 영향을 미치지 않지만 프로그램의 이해 및 소스 코드의 분석을 위해 반드시 기술할 것을 권장
	
	주석 태그는 JSP 웹 페이지에서만 사용되며, 웹 브라우저를 통해 해당 페이지의 출력 결과를 확인하거나
	웹 브라이저상에서 소스 보기를 해도 주석 태그 내의 내용이 표시 X --%>
	
	<%!
		// 선언문 태그를 사용하여 자바 변수와 메소드 정의 
		int count = 3;
	String makeItLower(String data) {
		return data.toLowerCase();
	}
	%>
	
	<%
		// 스크립틀릿 태그로 자바 로직 코드 작성
		for(int i = 1; i <= count; i++) {
			out.println("Java Sever Page" + i + ".<br>");
		}
	%>
	
	<%-- 표현문 태그로 선언문의 메소드를 호출하여 문자열 형태로 출력 --%>
	<%=makeItLower("Hello Wolrd") %>
</body>
</html>
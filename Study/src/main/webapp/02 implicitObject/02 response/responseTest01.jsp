<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Implicit Object : response</title>
</head>
<body>
	<h3>response 내장 객체를 이용하여 다음 조건에 맞게 JSP 애플리케이션을 만들고 실행 결과를 확인하시오</h3>
	<p>
		1. responseTest01.jsp 파일을 생성합니다<br>
		response 내장 객체의 setHeader() 메소드를 이용하여 5초마다 페이지를 갱신하도록 작성합니다.<br>
		java.util.Calendar 클래스를 이용하여 현재 시간을 출력하도록 작성합니다.<br>
		<구글 홈페이지로 이동하기> 를 클릭하면 response_data.jsp 파일을 연결하도록 작성합니다.<br><br>
		
		2. response_data.jsp 파일을 생성합니다 <br>
		response 내장 객체의 sendRedirect()메소드를 이용하여 구글 홈페이지로 이동하도록 작성합니다.
	</p>
	
	<%	
		response.setHeader("Refresh", "5");
	%>
	
	<p><a href="./response_data.jsp">구글 홈페이지로 이동하기</a>
	<%
		out.println(java.util.Calendar.getInstance().getTime());
	%>
	 
</body>
</html>
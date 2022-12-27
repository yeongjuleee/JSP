<%-- import 하는 방법
	<%@ page import="java.util.클래스(객체)명" %>
 --%>
<%@ page import="java.util.Calendar" %>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Implicit Object : response</title>
</head>
<body>
	<%
		// setHeader("실행할 명령", "문자로 시간적기")
		// setIntHeader("실행할 명령", 숫자로 시간적기)
		response.setHeader("Refresh", "5");
		Calendar calendar = Calendar.getInstance();
		String am_pm;
		int hour = calendar.get(Calendar.HOUR_OF_DAY);
		int minute = calendar.get(Calendar.MINUTE);
		int second = calendar.get(Calendar.SECOND);
		
		if(hour < 12) 
			am_pm = " AM";
		else {
			am_pm = " PM";
			hour = hour - 12;
		}
		String CT = hour + ":" + minute + ":" + second + am_pm;
	%>
	
	<p><a href="./response_data.jsp">Google 홈페이지로 이동하기</a></p>
</body>
</html>
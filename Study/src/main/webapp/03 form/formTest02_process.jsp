<%@ page import="java.util.Enumeration" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Form Processing</title>
</head>
<body>
	<%
		request.setCharacterEncoding("UTF-8");
		String[] fru = request.getParameterValues("fru");
	%>
	
	<p><b>선택한 과일</b></p>
	<br>
	
	<%
		if(fru != null) { // fru가 채워져(=체크되어) 있다면,
			for(int i = 0; i < fru.length; i++) { // fru 의 길이만큼 반복하고, fru의 인덱스 값 i를 증가시킴.
				out.println("<b>" + " " + fru[i] + "</b>"); // 체크되어 있는 fru의 인덱스 값을 출력
			}
		}
	%>
</body>
</html>
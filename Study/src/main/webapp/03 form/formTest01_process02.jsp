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
	<h3>form 태그를 이용하여 다음 조건에 맞게 JSP 애플리케이션을 만들고 실행 결과를 확인하시오.</h3>
	<p>
		1. formTest01_process.jsp 파일을 생성합니다. <br>
		Enumeration 클래스를 이용하여 전송된 모든 요청 파라미터 값을 받습니다. <br>
		String을 이용하여 전송된 요청 파라미터 이름과 값을 저장하여 출력합니다.<br><br>
	</p>
	
	<%
		request.setCharacterEncoding("UTF-8");
	
		Enumeration paramNames = request.getParameterNames();
		
		while (paramNames.hasMoreElements()) {
			StringBuffer info = new StringBuffer ((String) paramNames.nextElement());
			out.print("<b>" + info + " </b> " + " : " + "\n");
			
			String infoValue = request.getParameter(info.toString());
			out.println(infoValue + "<br>");
		}
	%>

</body>
</html>
<%@ page import="java.util.Enumeration" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Form Processing : 표로 보이게 하기 & 체크박스에서 여러개 체크하면 여러개 나오게 하는 경우</title>
</head>
<body>
	<table border="1">
		<tr>
			<th>요청 파라미터 이름</th>
			<th>요청 파라미터 값</th>
		</tr>

		<%-- 회원가입 양식에서 폼 데이터를 한 번에 전송 받기

	   1) 폼 페이지에서 전송된 요청 파라미터를 받도록 request 내장 객체의 getParameterNames() 메소드를 작성
	   2) 폼 페이지에서 전송된 요청 파라미터가 없을 때까지 반복하도록 hasMoreElements() 메소드를 작성
	   3) 폼 페이지에서 전송되 요청 파라미터의 이름을 가져오도록 nextElement() 메소드를 작성
	   4) 폼 페이지에서 전송된 요청 파라미터의 값을 가져오도록 요청 파라미터의 이름으로 request 내장 객체의 getParameter() 메소드 작성 --%>

		<%
			request.setCharacterEncoding("UTF-8");
		
			Enumeration paramNames = request.getParameterNames();
			while (paramNames.hasMoreElements()) {
				String name = (String) paramNames.nextElement();
				out.print("<tr><td>" + name + " </td>\n");
			
				// hobby 여러개 뜨게 할 경우 (추가됨. 위에 하나만 뜨게할 경우 주석해야함.)
				if(name.equals("hobby")) {
					String[] paramValue = request.getParameterValues(name);
					out.println("<td> ");
					
					if (paramValue != null) {
						for (int i=0; i < paramValue.length; i++) {
							out.println(" " + paramValue[i]);
						}
					}
					out.println("</td></tr>\n");
				}
				else {
					String paramValue = request.getParameter(name);
					out.println("<td> " + paramValue + "</td></tr>\n");
				}
			}
		%>

	</table>
</body>
</html>
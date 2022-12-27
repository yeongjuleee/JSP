<%@ page import="java.util.Enumeration" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>member_insert_action</title>
</head>
<body>
	<table border="1">
		<tr>
			<th>요청 파라미터 이름</th>
			<th>요청 파라미터 값</th>
		</tr>
	
	
	
	<%
		request.setCharacterEncoding("UTF-8");
	
		Enumeration paramNames = request.getParameterNames();
		while (paramNames.hasMoreElements()) {
			String name = (String) paramNames.nextElement();
			out.print("<tr><td>" + name + " </td>\n");
		
			if(name.equals("interest")) {
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
	
		<tr>
			<td>ip</td> 
			<td><%=request.getRemoteAddr() %></td>
		</tr>
	</table>
</body>
</html>
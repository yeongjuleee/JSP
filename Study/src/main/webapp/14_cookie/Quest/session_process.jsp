<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Session</title>
</head>
<body>
	<%
		String user_id = request.getParameter("id");
		// user_id 에 id값을 저장함
		String user_pw = request.getParameter("passwd");
		
		if(user_id.equals("admin") && user_pw.equals("1234")) {
			session.setAttribute("userID", user_id);
			// 세션 userID에 user_id 를 설정
			
			response.sendRedirect("session_welcome.jsp");
		}
		else {
			out.println("세션 설정이 실패했습니다.");
		}
	%>
</body>
</html>
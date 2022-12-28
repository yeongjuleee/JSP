<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Welcome</title>
</head>
<body>
	<form action="cookie_out.jsp" method="post">
		<input type="submit" value="로그아웃">
	</form>
	
	 <%
		String user_id = request.getParameter("id");
		String id = null;
		Cookie[] cookies = request.getCookies();
 		
	 	for(int i = 0; i < cookies.length; i++) {
	 		if(cookies[i].getName().equals("userID") && cookies[i].getValue() != null) {
			id = cookies[i].getValue();
			
			out.print(id + "님 환영합니다.");
	 		}
	 	}
	 	
	 	if(id == null) { // 새로고침해서 쿠키가 날아가면, 다시 로그인창으로 보내기
	 		response.sendRedirect("cookie.jsp");
	 	}
		
	 %>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Session</title>
</head>
<body>
	<!-- 세션 설정하기
		1.  전송된 아이디 비번이 일치하면 세션 속성 이름 userID, userPW에 값을 설정하도록 
			session 내장 객체의 setAttribute() 메소드 작성
		2.  일치 X => 실패 메시지 출력
	 -->
	 
	<%
		String user_id = request.getParameter("id");
		String user_pw = request.getParameter("passwd");
		
		if(user_id.equals("admin") && user_pw.equals("1234")) {
			session.setAttribute("userID", user_id);
			session.setAttribute("userPW", user_pw);
			
			out.println("세션 설정 성공했습니다<br>");
			out.println(user_id + "님 환영합니다");
		}
		else {
			out.println("세션 설정이 실패했습니다.");
		}
	%>
</body>
</html>
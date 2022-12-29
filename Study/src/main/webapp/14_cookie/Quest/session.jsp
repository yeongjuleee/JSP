<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Session</title>
</head>
<body>
<!-- 문제,
    1. session.isp 파일을 생성합니다.
    - input 태그에 text 유형을 이용하여 아이디, 비밀번호 항목을 작성합니다.
    - form 태그의 action 속성 값은 session_process.jsp 로 작성합니다.

    2. session_process.jsp 파일을 생성합니다.
    - request 내장 객체의 getParameter() 메서드를 이용하여 전송된 요청 파라미터 값을 받습니다.
    - 아이디와 비밀번호가 인증되면 아이디 값을 세션명 userID 의 세션 값으로 설정합니다.
    - response 내장 객체의 sendRedirect() 메서드를 이용하여 welcome.jsp 파일로 이동하도록 작성합니다.

    3. welcome.jsp 파일을 생성합니다.
    - 이 페이지는 로그인이 된 사용자만 접근 가능한 페이지입니다.
    - 설정된 세션명 userID 값이 null이면 response 내장 객체의 sendRedirect 메서드를 이용하여 session.jsp 파일로 이동합니다.
    - 설정된 세션명 userID 값이 null이 아니면 안내 메시지를 출력합니다. 예) admin님 반갑습니다.
    - <로그아웃>을 클릭하면 설정된 세션을 해제하도록 작성합니다.

    4.session_out.jsp 파일을 생성합니다.
    - 설정된 모든 세션명을 해제하도록 작성합니다.
    - response 내장 객체의 sendRedirect() 메서드를 이용하여 session.jsp 파일로 이동하도록 작성합니다.
-->

 	<form action="session_process.jsp" method="post">
		<p>아 이 디 : <input type="text" name="id" >
		<p>비밀 번호 : <input type="text" name="passwd">
		<p> <input type="submit" value="전송">
	</form>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Page_01</title>
</head>
<body>
<!--
    2. 세션을 이용하여 다음 조건에 맞게 JSP 애플리케이션을 만들고 실행 결과들 확인하시오.
    1) page_01.jsp 파일을 생성합니다.
    - '회원 전용 페이지 이동' 이라는 텍스트를 클릭하면 page_02.jsp로 이동하도록 합니다.
    
    2) page_02.jsp 파일을 생성합니다.
    - '회원 전용 페이지 입니다' 라는 글이 나오도록 합니다.
    - '로그 아웃' 이라는 텍스트를 클릭하면 logout.jsp 로 이동하도록 합니다.
    - 세션명 userlD에 저장된 값이 없으면 response 내장 객체의 sendRedirect 메서드를 이용하여 login.jsp 파일로 이동하도록 작성합니다.
    
    3) login.jsp 파일을 생성합니다.
    - input 태그에 text 유형을 이용하여 아이디, 비밀번호 항목을 작성합니다.
    - form 태그의 action 속성 값은 login_process.jsp 로 작성합니다.
    
    4) login_ process.jsp 파일을 생성합니다.
    - request 내장 객체의 getParameter() 메서드를 이용하여 전송된 요청 파라미터 값을 받습니다.
    - 아이디와 비밀번호가 인증되면 아이디 값을 세션명 userID 의 세션 값으로 설정합니다.
    - response 내장 객체의 sendRedirect 메서드를 이용하여 page_01.jsp 파일로 이동하도록 작성합니다.
    
    5) logout.jsp 파일을 생성합니다.
    - 설정된 모든 세션명을 해제하도록 작성합니다.
    - response 내장 객체의 sendRedirect 메서드를 이용하여 page_01.jsp 파일로 이동하도록 작성합니다.
    
    6) 로그인이 된 상태에서, 로그인이 안된 상태에서 각각 page_02.jsp 페이지로 접근을 해서 차이점을 확인 합니다.
-->
	<form action="page_02.jsp" method="post">
		<input type="submit" value="회원 전용 페이지 이동">
	</form>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%-- 문제,
	1. MultipartRequest 클래스를 이용하여 다음 조건에 맞기 JSP 애플리케이션을 만들고 실행 결과를 확인하라
		-cos.jar 클래스 사용
		-fileupload01.jps 파일 생성
		-input 태그 내 file 유형을 이용하여 파일 항목을 작성
		-form 태그의 action 속성 값은 fileupload01_process.jsp 로, enctype 속성 값은 multipart/form-data로 작성
	2. fileupload01_process 파일 생성
		-MultipartRequest 클래스를 사용하여 요청 파라미터 이름, 실제 파일 이름, 저장 파일, 파일 컨텐츠 유형, 파일 크기를 출력 --%>
	<form name="fileForm" method="post" enctype="multipart/form-data" action="fileupload01_process.jsp">
		<p>이 름 : <input type="text" name="name"></p>
		<p>제 목 : <input type="text" name="subject"></p>
		<p>파 일 : <input type="file" name="filename"></p>
		<p><input type="submit" value="파일 올리기"></p>
	</form>
</body>
</html>
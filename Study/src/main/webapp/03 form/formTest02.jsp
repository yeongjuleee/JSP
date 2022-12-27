<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Form Processing</title>
</head>
<body>
	<h2>form 태그를 이용하여 다음 조건에 맞게 JSP 애플리케이션을 만들고 실행 결과를 확인하시오</h2>
	<p>
		1. formTest02.jsp 파일을 생성합니다. <br>
		-input 태그 내에 check 유형을 이용하여 오렌지, 사과, 바나나 항목을 작성합니다. <br>
		-form 태그의 action 속성 값은 formTest02_process.jsp 로 작성합니다. <br><br>
		
		2. formTest02_process.jsp 파일을 생성합니다. <br>
		-request 내장 객체의 getParameterValues() 메소드를 이용하여 전송된 요청 파라미터 값을 전달 받아 출력합니다. <br><br>
	</p>
	
	<form action="./formTest02_process.jsp" method="post">
		<p>사과 <input type="checkbox" name="fru" value="사과" checked>
		   오렌지 <input type="checkbox" name="fru" value="오렌지">
		   바나나 <input type="checkbox" name="fru" value="바나나"></p>
		<p><input type="submit" value="전송"></p>
	</form>
</body>
</html>
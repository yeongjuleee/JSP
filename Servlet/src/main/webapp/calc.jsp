<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Title</title>
</head>
<body>
	<h2>계산기 서블릿</h2>
	<hr>
	<!-- 
		2개의 숫자와 연산자를 선택하고 실행 버튼을 누르면 입력값을 서블릿으로 전달
		서블릿은 브라우저로 전달된 입력값을 가져와 계산 후 결과를 포함한 화면을 출력하는 구조
		
		입력 파라미터
		* n1, n2 : 숫자 입력
		* op : 연산자  선택 드롭 다운 리스트
	 -->
	 
	 <form method="post" action="calc.cal">
	 	<input type="text" name="n1" size="10">
	 	<select name="op">
	 		<option>+</option>
	 		<option>-</option>
	 		<option>*</option>
	 		<option>/</option>
	 	</select>
	 	<input type="text" name="n2" size="10">
	 	<input type="submit" value="실행">
	 </form>
</body>
</html>
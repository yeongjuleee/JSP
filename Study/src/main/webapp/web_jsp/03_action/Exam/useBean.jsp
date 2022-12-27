<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%--
	3. 다음 조건에 맞게 JSP 애플리케이션을 만들고 실행 결과를 확인하시오.
	
	1) GuGuDan 클래스를 생성하여 곱셈을 계산하는 process() 메소드를 작성.
	* uceRean 파일을 생성
	useBean 액션태그에 GuGuDan 클래스를 사용하도록 작성.
	<h4> 태그에 '구구단 출력하기'를 작성.
	숫자 5에 대해 GuGuDan 클래스의 process(5, 1) 메소드를 호출, 30반환하여 구구단을 출력.
	--%>
	
	<jsp:useBean id="bean" class="exam.GuGuDan" />
	<%
		out.print("<5단>" + "<br>");
		int num1 = 5;
		for(int i=1; i<10; i++) {
			out.print(num1 + " * " + i +" = " + bean.process(num1,i) + "<br>" );
		}
		
	%>
</body>
</html>
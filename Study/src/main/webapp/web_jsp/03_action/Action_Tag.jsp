<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Action Tag</title>
</head>
<%--
	 표준 액션 태그?
	 미리 정해진 기능들을 JSP 스펙에 명시 => 모든 컨테이너가 동일하게 구현하는 태그
	 모든 JSP 컨테이너에서 기본으로 제공하고 있어서 기본 액션 태그라고도 함.
 --%>

<body>
	<%-- 
	forward : 다른 페이지로 이동할 때 사용하는 태그
	forward 액션 태그로 현재 날짜와 시각을 출력하는 페이지로 이동하기.
	1. 외부 파일 forward_date.jsp 의 내용을 출력하도록 forward 액션 태그의 page 속성을 작성 --%>
	
	<h2>forward 액션 태그</h2>
	<jsp:forward page="forward_date.jsp" />
	<p>---------------------------------</p>
</body>
</html>
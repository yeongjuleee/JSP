<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JSTL</title>
</head>
<body>
	<%--
		<sql:update> 태그로 INSERT 쿼리문 실행하기
	 --%>
	 
	 <%
	 	request.setCharacterEncoding("utf-8");
	 	
	 	String id = request.getParameter("id");
	 	String passwd = request.getParameter("passwd");
	 	String name = request.getParameter("name");
	 %>
	 <sql:setDataSource var="dataSource"
	 	url="jdbc:mariadb://localhost:3308/member"
	 	driver="org.mariadb.jdbc.Driver" user="root" password="0732" />
	 	
	 <%-- member 테이블에 새로운 필드 값을 삽입하도록 <sql:update> 태그로 INSERT문 작성 --%>
	 <sql:update dataSource="${dataSource }" var="resultSet">
	 	INSERT INTO member(id, name, passwd) VALUES (?, ?, ?)
	 	<%-- 폼 페이지에서 전송된 아이디, 이름, 비밀번호를 쿼리문의 물음표에 설정하도록 <sql:param>태그를 작성 --%>
	 	<sql:param value="<%=id %>" />
	 	<sql:param value="<%=name %>" />
	 	<sql:param value="<%=passwd %>" />
	 </sql:update>
	 <c:import var="url" url="sql01.jsp" />
	 ${url}
</body>
</html>
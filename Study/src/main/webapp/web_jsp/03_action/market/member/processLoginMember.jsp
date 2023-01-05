<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.*" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql"%>
<%
	request.setCharacterEncoding("UTF-8");
	
	String id = request.getParameter("id");
	String password = request.getParameter("password");
%>

<sql:setDataSource var="dataSource"
	url="jdbc:mariadb://localhost:3308/market"
	driver="org.mariadb.jdbc.Driver" user="root" password="0732" />
	
<sql:query dataSource="${dataSource }" var="resultSet">
	SELECT * FROM member WHERE id = ? and password = ?
	<sql:param value="<%=id %>" />
	<sql:param value="<%=password %>" />
</sql:query>

<c:forEach var="row" items="${resultSet.rows }">
	<%
		session.setAttribute("sessionId", id);
	%>
	<c:redirect url="resultMember.jsp?msg=2" />
</c:forEach>

<c:redirect url="loginMember.jsp?error=1" />
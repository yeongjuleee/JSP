<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.*" %>
<%@ page import="bookstore.dao.CartDAO" %>
<%@ include file="../inc/dbconn.jsp" %>

<%--기존 것 jstl 사용 방법 
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql"%>
<%
	request.setCharacterEncoding("UTF-8");
	
	String id = request.getParameter("id");
	String password = request.getParameter("password");
%>

<sql:setDataSource var="dataSource"
	url="jdbc:mariadb://localhost:3308/bookmarket"
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
--%>

<%
	request.setCharacterEncoding("UTF-8");
	
	String id = request.getParameter("id");
	String passwd = request.getParameter("password");
	String sql = "SELECT * FROM member WHERE id = ? AND password = ?";
	pstmt = conn.prepareStatement(sql);
	pstmt.setString(1, id);
	pstmt.setString(2, passwd);
	rs = pstmt.executeQuery();
	
	if(rs.next()) {
		session.setAttribute("sessionId", id);
		session.setAttribute("sessionName", rs.getString("name"));
		
		CartDAO cartDAO = new CartDAO();
		cartDAO.updateCartBylogin(session);
		response.sendRedirect("resultMember.jsp?msg=2");
	}
	else {
		response.sendRedirect("loginMember.jsp?error=1");
	}
%>
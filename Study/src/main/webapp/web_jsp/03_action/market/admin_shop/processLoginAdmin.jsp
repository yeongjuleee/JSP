<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.*" %>
<%@ include file="../inc/dbconn.jsp" %>

<%
	request.setCharacterEncoding("UTF-8");
	
	String id = request.getParameter("id");
	String passwd = request.getParameter("password");
	
	String sql = "SELECT * FROM admin WHERE id = ? AND password = ?";
	pstmt = conn.prepareStatement(sql);
	pstmt.setString(1, id);
	pstmt.setString(2, passwd);
	rs = pstmt.executeQuery();
	if (rs.next()) { // 로그인 처리
		// 세션을 구움
		session.setAttribute("sessionAdminId", rs.getString("id"));
		session.setAttribute("sessionAdminName", rs.getString("name"));
		session.setAttribute("sessionAdminDay", rs.getString("lately_login_day"));
		
		// 최근 로그인한 날자를 변경
		sql = "UPDATE admin SET lately_login_day = now() WHERE id = ? and password = ?";
		pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, id);
		pstmt.setString(2, passwd);
		pstmt.executeUpdate();
		
		// 인덱스 페이지로 이동
		response.sendRedirect("index.jsp");
	}
	else {
		response.sendRedirect("loginAdmin.jsp?error=1");
	}
%>




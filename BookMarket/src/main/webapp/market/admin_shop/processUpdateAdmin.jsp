<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.*" %>
<%@ include file="../inc/dbconn.jsp" %>


<%

   request.setCharacterEncoding("UTF-8");
   
   String id = (String)session.getAttribute("sessionAdminId");
   String passwd = request.getParameter("password");
   String name = request.getParameter("name");
   
   String sql = "UPDATE admin SET password = ?, name =? WHERE id = ?";
   pstmt = conn.prepareStatement(sql);
   pstmt.setString(1, passwd);
   pstmt.setString(2, name);
   pstmt.setString(3, id);
   
   int result = pstmt.executeUpdate();
   
   if (result == 1) { // 정보 수정 처리
	   session.setAttribute("sessionAdminName", name);
	   response.sendRedirect("index.jsp");	

	}
	else {
		response.sendRedirect("updateAdmin.jsp");
	}
%>

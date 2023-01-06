<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	/* session 전체 삭제하기
	session.invalidate();*/
	
	//  세션 속성 개별 삭제하기
	session.removeAttribute("sessionAdminId");
	session.removeAttribute("sessionAdminName");
	session.removeAttribute("sessionAdminDay");
	
	response.sendRedirect("loginAdmin.jsp");
%>
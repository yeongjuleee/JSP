<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.ArrayList" %>
<%@ page import="market.dto.Product" %>
<%@ page import="market.dao.ProductRepository"%>

<!-- 전체 삭제하기 -->
<%
	session.invalidate();

	response.sendRedirect("cart.jsp");
%>
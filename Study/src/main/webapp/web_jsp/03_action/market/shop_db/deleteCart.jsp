<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.ArrayList" %>
<%@ page import="market.dao.ProductRepository"%>
<%@ page import="market.dto.Product" %>
<%@ page import="market.dao.ProductDAO" %>
<%@ page import="market.dao.CartDAO" %>
<%@ page import="market.dto.CartDTO" %>

<!-- 전체 삭제하기 -->
<%
	String orderNum = session.getId();
	CartDAO cartDAO = new CartDAO();
	cartDAO.deleteCartAll(orderNum);
	

	response.sendRedirect("cart.jsp");
%>
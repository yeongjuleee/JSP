<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.ArrayList" %>
<%@ page import="bookstore.dto.Book" %>
<%@ page import="bookstore.dao.BookRepository"%>
<%@ page import="bookstore.dao.BookDAO" %>
<%@ page import="bookstore.dao.CartDAO" %>
<%@ page import="bookstore.dto.CartDTO" %>
<%@ page import="bookstore.dto.Book" %>

<!-- 전체 삭제하기 -->
<%
	String orderNum = session.getId();
	CartDAO cartDAO = new CartDAO();
	cartDAO.deleteCartAll(orderNum);
	
	
	response.sendRedirect("cart.jsp");
%>
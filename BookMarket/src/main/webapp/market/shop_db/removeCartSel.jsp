<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.ArrayList" %>
<%@ page import="bookstore.dto.Book" %>
<%@ page import="bookstore.dao.BookRepository"%>
<%@ page import="bookstore.dao.BookDAO" %>
<%@ page import="bookstore.dao.CartDAO" %>
<%@ page import="bookstore.dto.CartDTO" %>
<%@ page import="bookstore.dto.Book" %>

<%
	CartDAO cartDAO = new CartDAO();
	String orderNum = session.getId();
	
	// 방법 1. 배열로 넘어온 chkID를 사용하여 미리 만들어진 deleteCartById() 메소드 사용
	String [] cartIds = request.getParameterValues("chkID");
	
	for (String cartId : cartIds) {
		cartDAO.deleteCartById(orderNum, Integer.parseInt(cartId));
	}
	
	// 방법 2. 문자열로 넘어온 chkdID 사용하여 새로운 메소드 만들기
	/*
	String chkdID = request.getParameter("chkdID");
	CartDAO.deleteCartBySelId(orderNum, chkdID);
	*/
	response.sendRedirect("cart.jsp");
	
%>
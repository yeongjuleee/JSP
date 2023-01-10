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
	String id = request.getParameter("id");
	if (id == null || id.trim().equals("")) {
		response.sendRedirect("bookstore.jsp");
		return;
	}
	
	BookDAO bookDAO = new BookDAO();
	
	Book bookDTO = bookDAO.getBookById(id);
	if (bookDTO == null) {
		response.sendRedirect("../exception/exeptionNoBookId.jsp");
	}
	
	String orderNum = session.getId();
	String sessionId = (String)session.getAttribute("sessionId");
	
	CartDAO cartDAO = new CartDAO();
	
	boolean flag = cartDAO.updateCart(bookDTO, orderNum, sessionId);
	
	response.sendRedirect("book.jsp?id=" + id);
%>

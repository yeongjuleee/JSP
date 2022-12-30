<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.ArrayList" %>
<%@ page import="bookstore.dto.Book" %>
<%@ page import="bookstore.dao.BookRepository"%>

<%
	/* 장바구니에서 상품을 개별 삭제 */
	String id = request.getParameter("id");
	if(id == null || id.trim().equals("")) {
		response.sendRedirect("products.jsp");
		return;
	}
	
	BookRepository dao = BookRepository.getInstance();
	
	Book product = dao.getBookById(id);
	if (product == null) {
		response.sendRedirect("exceptionNoProductId.jsp");
	}
	
	ArrayList<Book> cartList = (ArrayList<Book>) session.getAttribute("cartlist");
	
	// for문 뽀이찌문으로 바꾸기
	Book goodsQnt = new Book();
	for (int i = 0; i < cartList.size(); i++) { // 상품 리스트 하나씩 출력하기
		goodsQnt = cartList.get(i);
		if(goodsQnt.getBookId().equals(id)) {
			cartList.remove(goodsQnt);
		}
	}
	
	response.sendRedirect("cart.jsp");
%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.ArrayList" %>
<%@ page import="market.dto.Product" %>
<%@ page import="market.dao.ProductRepository"%>

<%
	/* 장바구니에서 상품을 개별 삭제 */
	String id = request.getParameter("id");
	if(id == null || id.trim().equals("")) {
		response.sendRedirect("products.jsp");
		return;
	}
	
	ProductRepository dao = ProductRepository.getInstance();
	
	Product product = dao.getProductById(id);
	if (product == null) {
		response.sendRedirect("exceptionNoProductId.jsp");
	}
	
	ArrayList<Product> cartList = (ArrayList<Product>) session.getAttribute("cartlist");
	
	// for문 뽀이찌문으로 바꾸기
	Product goodsQnt = new Product();
	for (int i = 0; i < cartList.size(); i++) { // 상품 리스트 하나씩 출력하기
		goodsQnt = cartList.get(i);
		if(goodsQnt.getProductId().equals(id)) {
			cartList.remove(goodsQnt);
		}
	}
	
	response.sendRedirect("cart.jsp");
%>
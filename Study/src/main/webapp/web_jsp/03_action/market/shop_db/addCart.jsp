<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.ArrayList" %>
<%@ page import="market.dto.Product" %>
<%@ page import="market.dao.ProductRepository"%>
<%@ page import="market.dao.ProductDAO" %>
<%@ page import="market.dao.CartDAO" %>
<%@ page import="market.dto.CartDTO" %>
<%@ page import="market.dto.Product" %>

<%
	String id = request.getParameter("id");
	if (id == null || id.trim().equals("")) {
		response.sendRedirect("products.jsp");
		return;
	}
	
	ProductDAO productDAO = new ProductDAO();
	
	Product productDTO = productDAO.getProductById(id);
	if (productDTO == null) {
		response.sendRedirect("../exception/exeptionNoProductId.jsp");
	}
	
	String orderNum = session.getId();
	String sessionId = (String)session.getAttribute("sessionId");
	
	CartDAO cartDAO = new CartDAO();
	
	boolean flag = cartDAO.updateCart(productDTO, orderNum, sessionId);
	
	response.sendRedirect("product.jsp?id=" + id);
	
	/* 기존 꺼
	ProductRepository dao = ProductRepository.getInstance();
	
	 해당되는 상품 코드의 존재 여부 확인
	Product product = dao.getProductById(id);
	if(product == null) {
		response.sendRedirect("exeptionNoProductId.jsp");
	}
	
	// 요청 파라미터 아이디의 상품을 담은 장바구니를 초기화 하도록 작성
	ArrayList <Product> list = (ArrayList<Product>) session.getAttribute("cartlist");
	// 세션에다 cartlist의 값을 가지고 오는데, 그 값을 ArrayList 에 저장
	if(list == null) {
		list = new ArrayList<Product>();
		session.setAttribute("cartlist", list);
	} // 세션이 작업된 부분임.  =>장바구니(cart) 들고왔음.
	
			
	// int cnt = 0 ~ if 문까지 수정해보기 
	// for 문은 forEach로 수정해보기
	int cnt = 0;
	// 기존 장바구니에 담긴 상품인지 확인하기 위한 용도
	
	//Product goodsQnt = new Product();
	//for (int i = 0; i < list.size(); i++) {
	//	goodsQnt = list.get(i);
	//	if (goodsQnt.getProductId().equals(id)) {
	//		cnt++;
	//		int orderQuantity = goodsQnt.getQuantity() + 1;
	//		goodsQnt.setQuantity(orderQuantity);
	//	}
	//}
	
	for(Product goodsQnt : list) {
		if(goodsQnt.getProductId().equals(id)) {
			cnt++;
			int orderQuantity = goodsQnt.getQuantity() + 1;
			goodsQnt.setQuantity(orderQuantity);
		}
	}
	
	if ( cnt == 0) {
		product.setQuantity(1);
		list.add(product);
	}
	
	response.sendRedirect("product.jsp?id=" + id);
	*/
%>

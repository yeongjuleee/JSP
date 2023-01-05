<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="market.dto.Product" %>
<%@ page import="market.dao.ProductRepository" %>
<%@ page errorPage = "exceptionNoProductId.jsp" %>
<%@ page import="java.sql.*" %>
<%@ include file="../inc/dbconn.jsp" %>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="../resources/css/bootstrap.min.css"/>
<meta charset="UTF-8">
<title>상품 상세 정보</title>

<script type="text/javascript">
	function addToCart() { // 장바구니 상품 추가 함수
		if (confirm("상품을 장바구니에 추가하시겠습니까?")) {
			document.addForm.submit(); // addForm 만들기
		} else {
			document.addForm.reset();
		}
	}
</script>

</head>

<body>
	<jsp:include page="../inc/menu.jsp" />
	<div class="jumbotron">
		<div class="container">
			<h1 class="display-3">상품목록</h1>
		</div>
	</div>
	<%
		/* 기존것
		String id = request.getParameter("id");
		ProductRepository dao = ProductRepository.getInstance();
		Product product = dao.getProductById(id);
		*/
		
		// DB 연결 후 
		String productId = request.getParameter("id");
   
     	String sql ="select * from product where p_id = ?";
      	pstmt = conn.prepareStatement(sql);
      	pstmt.setString(1, productId);
      	rs = pstmt.executeQuery();
      	if(rs.next()) { // if문 시작
	
	%>
	
	<div class="container">
		<div class="row">
			<div class="col-md-5">
				<img src="${pageContext.request.contextPath}/resources/images/<%=rs.getString("p_fileName")%>"
				style="width: 100%" />
			</div>
			<div class="col-md-6">
				<h3><%=rs.getString("p_name") %></h3>
				<p><%=rs.getString("p_description") %></p>
				<p><b>상품 코드 : </b><span class="badge badge-danger"> <%=rs.getString("p_id") %></span>
				<p><b>제조사</b> : <%=rs.getString("p_manufacturer") %></p>
				<p><b>분류</b> : <%=rs.getString("p_category") %></p>
				<p><b>재고 수</b> : <%=rs.getString("p_unitsInStock") %></p>
				<h4><%=rs.getString("p_unitPrice") %>원</h4>
				<p>
					<!-- 희윤이가 이 방법은 좋지 않대. 나중에 스스로 수정해야만 한대 -->
					<form name="addForm" action="./addCart.jsp?id=<%=rs.getString("p_id") %>" method="post">
						<a href="#" class="btn btn-info" onclick="addToCart()">상품 주문 &raquo;</a>
						<a href="./cart.jsp" class="btn btn-warning">장바구니 &raquo;</a>
						<a href="./products.jsp" class="btn btn-secondary">상품 목록 &raquo;</a>
					</form>
			</div>
		</div>
		<%
      		}
		
			if (rs != null) rs.close();
			if (pstmt != null) pstmt.close();
			if (conn != null) conn.close();
		%>
		<hr>
	</div>
	<jsp:include page="../inc/footer.jsp" />	
</body>
</html>
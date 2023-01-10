<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="bookstore.dto.Book" %>
<%@ page import="bookstore.dao.BookRepository" %>
<%@ page errorPage="exceptionNoBookId.jsp" %>
<%@ page import="java.sql.*" %>
<%@ include file="../inc/dbconn.jsp" %>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css">
<meta charset="UTF-8">
<title>도서 상세 정보</title>

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
			<h1 class="display-3">도서목록</h1>
		</div>
	</div>
	<%
		/* 기존것
		String id = request.getParameter("id");
		BookRepository dao = BookRepository.getInstance();
		Book book = dao.getBookById(id);
		*/
		
		// DB연결로 수정
		String bookId = request.getParameter("id");
   
      	String sql = "select * from bookstore where b_id = ?";
      	pstmt = conn.prepareStatement(sql);
      	pstmt.setString(1, bookId);
      	rs = pstmt.executeQuery();
		if (rs.next()) {
			
	%>
	
	<div class="container">
		<div class="col">
			<div class="col-md-5">
				<img src="${pageContext.request.contextPath}/resources/images/<%=rs.getString("b_fileName")%>"
				style="max-width: 100%" />
			</div>
			<div class="col-md-12">
				<h3><%=rs.getString("b_name") %></h3>
	            <p><%=rs.getString("b_description") %></p>
	            <p><b>도서 코드 : </b><span class= "badge badge-danger"><%=rs.getString("b_id")%></span></p>
	            <p><b>저자 : </b><%=rs.getString("b_author")%></p>
	            <p><b>페이지 : </b><%=rs.getString("b_totalPages")%></p>
	            <p><b>출판사 : </b><%=rs.getString("b_publisher")%></p>
	            <p><b>분류 : </b><%=rs.getString("b_category")%></p>
	            <p><b>발간일 : </b><%=rs.getString("b_releaseDate")%></p>
	            <p><b>재고 : </b><%=rs.getString("b_unitsInStock")%></p>
	            <p><b>상태 : </b><%=rs.getString("b_condition")%></p>
              	<h4><%=rs.getString("b_unitPrice") %>원</h4>
				<p>
					<!-- 희윤이가 이 방법은 좋지 않대. 나중에 스스로 수정해야만 한대 -->
					<form name="addForm" action="./addCart.jsp?id=<%=rs.getString("b_id") %>" method="post">
						<a href="#" class="btn btn-info" onclick="addToCart()">상품 주문 &raquo;</a>
						<a href="./cart.jsp" class="btn btn-warning">장바구니 &raquo;</a>
						<a href="./bookstore.jsp" class="btn btn-secondary">상품 목록 &raquo;</a>
					</form>
				<hr>
			</div>
			<%
				}
				
				if (rs != null) rs.close();
				if (pstmt != null) pstmt.close();
				if (conn != null) conn.close();
			%>
		</div>
	</div>
	<jsp:include page="../inc/footer.jsp" />
</body>
</html>
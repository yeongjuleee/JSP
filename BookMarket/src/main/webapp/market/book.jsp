<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="bookstore.dto.Book" %>
<%@ page import="bookstore.dao.BookRepository" %>
<%@ page errorPage="exceptionNoBookId.jsp" %>
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
	<jsp:include page="menu.jsp" />
	<div class="jumbotron">
		<div class="container">
			<h1 class="display-3">도서목록</h1>
		</div>
	</div>
	<%
		String id = request.getParameter("id");
		BookRepository dao = BookRepository.getInstance();
		Book book = dao.getBookById(id);
	%>
	
	<div class="container">
		<div class="col">
			<div class="col-md-5">
				<img src="${pageContext.request.contextPath}/resources/images/<%=book.getFilename()%>"
				style="max-width: 100%" />
			</div>
			<div class="col-md-12">
				<h3><%=book.getName() %></h3>
	            <p><%=book.getDescription() %></p>
	            <p><b>도서 코드 : </b><span class= "badge badge-danger"><%=book.getBookId()%></span></p>
	            <p><b>저자 : </b><%=book.getAuthor()%></p>
	            <p><b>페이지 : </b><%=book.getTotallPages()%></p>
	            <p><b>출판사 : </b><%=book.getPublisher()%></p>
	            <p><b>분류 : </b><%=book.getCategory()%></p>
	            <p><b>발간일 : </b><%=book.getReleaseDate()%></p>
	            <p><b>재고 : </b><%=book.getUnitsInStock()%></p>
	            <p><b>상태 : </b><%=book.getCondition()%></p>
              	<h4><%=book.getUnitPrice() %>원</h4>
				<p>
					<!-- 희윤이가 이 방법은 좋지 않대. 나중에 스스로 수정해야만 한대 -->
					<form name="addForm" action="./addCart.jsp?id=<%=book.getBookId() %>" method="post">
						<a href="#" class="btn btn-info" onclick="addToCart()">상품 주문 &raquo;</a>
						<a href="./cart.jsp" class="btn btn-warning">장바구니 &raquo;</a>
						<a href="./bookstore.jsp" class="btn btn-secondary">상품 목록 &raquo;</a>
					</form>
				<hr>
			</div>
		</div>
	</div>
	<jsp:include page="footer.jsp" />
</body>
</html>
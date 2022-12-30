<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.ArrayList" %>
<%@ page import="bookstore.dto.Book" %>
<%@ page import="bookstore.dao.BookRepository"%>

<html>
<head>
<link rel="stylesheet" href="./resources/css/bootstrap.min.css"/>
<%
	String cartId = session.getId();
%>
<title>장바구니</title>
</head>

<body>
	<jsp:include page="menu.jsp" />
	<div class="jumbotron">
		<div class="container">
			<h1 class="display-3">장바구니</h1>
		</div>
	</div>
	
	<div class="container">
		<div class="row">
			<table width="100%">
				<tr>
					<td align="left"><span class="btn btn-danger" onclick="deleteCart()">삭제하기</span></td>
					<td align="right"><a href="./shippingInfo.jsp?cartId=<%=cartId%>" class="btn btn-success">주문하기</a></td>
				</tr>
			</table>
		</div>
		
		<div style="padding-top: 50px">
			<table class="table table-hover">
				<tr>
					<th>상품</th>
					<th>가격</th>
					<th>수량</th>
					<th>소계</th>
					<th>비고</th>
				</tr>
				<%
					int sum = 0;
					ArrayList<Book> cartList = (ArrayList<Book>) session.getAttribute("cartlist");
					if(cartList == null) {
						cartList = new ArrayList<Book>();
					
					}
					
					   //for(int i=0; i<cartList.size(); i++){ //상품리스트 하나씩 출력하기
		               //   Book book = cartList.get(i);
		               //   int total = book.getUnitPrice() * book.getQuantity();
		               //   sum = sum + total;
		               
		               for(Book book : cartList){
		                  int total = book.getUnitPrice() * book.getQuantity();
		                  sum += total;
					
				%>
				<tr>
					<td><%=book.getBookId()%> - <%=book.getName()%></td>
					<td><%=book.getUnitPrice()%></td>
					<td><%=book.getQuantity()%></td>
					<td><%=total%></td>
					<td><span class="badge badge-danger" onclick="removeCartByID('<%=book.getBookId()%>')">삭제</span></td>
				</tr>
				<%
					}
				%>
				<tr>
					<th></th>
					<th></th>
					<th>총액</th>
					<th><%=sum%></th>
					<th></th>
				</tr>
			</table>
			<a href="./bookstore.jsp" class="btn btn-secondary"> &laquo; 쇼핑 계속하기</a>
		</div>
		<form name="frmCart" method="post">
			<input type="hidden" name="id">
		</form>
		<script>
			let removeCartByID = function(ID) {
				if(confirm("삭제하시겠습니까?")) {
					frm.id.value = ID;
					frm.action = "removeCart.jsp";
					frm.submit();
				}
			}
			
			let deleteCart = function() {
				if(confirm("전체 삭제하시겠습니까?")) {
					frm.action = "deleteCart.jsp";
					frm.submit();	
				}
			}
			
		</script>
		<hr>
	</div>
	<jsp:include page="footer.jsp" />
</body>
</html>
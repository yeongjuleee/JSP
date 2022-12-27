<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.ArrayList" %>
<%@ page import="bookstore.dto.Book" %>
<%@ page import="bookstore.dao.BookRepository" %>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css">
<meta charset="UTF-8">
<title>Book Store</title>
</head>
<body>
	<jsp:include page="menu.jsp" />
	<div class="jumbotron">
		<div class="container">
			<h1 class="display-3">도서목록</h1>
		</div>
	</div>
	<%	
		// resource 경로 찾는 방법
		//String realPath = request.getServletContext().getRealPath("resources/images");
		//out.print(realPath); //=> 찍힌 경로를 폴더 주소에 찍고 이미지 다 옮기기
		BookRepository dao = BookRepository.getInstance();
		ArrayList<Book> listOfBooks = dao.getAllBooks();
	%>
	
	<div class="container">
		<div class="col">
			<% 
				for (int i = 0; i < listOfBooks.size(); i++) {
					Book book = listOfBooks.get(i);
			%>
			<div class="col-md-12">
				<img src="${pageContext.request.contextPath}/resources/images/<%=book.getFilename()%>"
				style = "width: 300px" alt="">
				<h3><%=book.getName() %></h3>
				<p><%=book.getCategory() %></p>
				<p><%=book.getUnitPrice() %>원</p>
				<p><%=book.getPublisher() %>
				<p><a href="./book.jsp?id=<%=book.getBookId()%>" class="btn btn-secondary" role="buntton">
				상세 정보 &raquo;</a></p>
				<hr>
			</div>
			<% 
				}
			%>
		</div>
		<%-- <hr> --%>
	</div>
	<jsp:include page="footer.jsp" />
</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<nav class = "navbar navbar-expand navbar-dark bg-dark">
<div class="container">
	<div class="navbar-header">
		<a class="navbar-brand" href ="./welcome.jsp">Home</a>
	</div>
	<div>
		<ul class="navbar-nav mr-auto">
			<li class="nav-item"><a class="nav-link" href="./bookstore.jsp">도서 목록</a></li>
			<li class="nav-item"><a class="nav-link" href="./addBook.jsp">도서 등록</a></li>
			<li class="nav-item"><a class="nav-link" href="./editBook.jsp?edit=update">도서 수정</a></li>
			<li class="nav-item"><a class="nav-link" href="./editBook.jsp?edit=delete">도서 삭제</a></li>
		</ul>
	</div>
</div>
</nav>

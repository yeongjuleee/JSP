<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<link rel="stylesheet" href="../resources/css/bootstrap.min.css"/>

<%
	String sessionId = (String)session.getAttribute("sessionId");
%>

<nav class = "navbar navbar-expand navbar-dark bg-dark">
<div class="container">
	<div class="navbar-header">
		<a class="navbar-brand" href ="../main/welcome.jsp">Home</a>
	</div>
	<div>
		<ul class="navbar-nav mr-auto">
			<c:choose>
				<c:when test="${empty sessionId }">
					<li class="nav-item"><a class="nav-link" href="<c:url value="../member/loginMember.jsp"/>">로그인</a></li>
					<li class="nav-item"><a class="nav-link" href="<c:url value="../member/addMember.jsp"/>">회원가입</a></li>
				</c:when>
				<c:otherwise>
					<li style="padding-top: 7px; color: white">[<%=sessionId%>님]</li>
					<li class="nav-item"><a class="nav-link" href="<c:url value="../member/logoutMember.jsp"/>">로그아웃</a></li>
					<li class="nav-item"><a class="nav-link" href="<c:url value="../member/updateMember.jsp"/>">회원 수정</a></li>
				</c:otherwise>
			</c:choose>
			<li class="nav-item"><a class="nav-link" href="../shop/bookstore.jsp">도서 목록</a></li>
			<li class="nav-item"><a class="nav-link" href="../admin/addBook.jsp">도서 등록</a></li>
			<li class="nav-item"><a class="nav-link" href="../admin/editBook.jsp?edit=update">도서 수정</a></li>
			<li class="nav-item"><a class="nav-link" href="../admin/editBook.jsp?edit=delete">도서 삭제</a></li>
			<%--<li class="nav-item"><a class="nav-link" href="../board/BoardListAction.do?pageNum=">상품 삭제</a></li> --%>
		</ul>
	</div>
</div>
</nav>

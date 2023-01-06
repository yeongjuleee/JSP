<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<link rel="stylesheet" href="../resources/css/bootstrap.min.css"/>
<%
	String sessionAdminId = (String)session.getAttribute("sessionAdminId");
	String sessionAdminName = (String)session.getAttribute("sessionAdminName");
	if (sessionAdminId == null) {
		response.sendRedirect("./loginAdmin.jsp");
	}
%>
<nav class = "navbar navbar-expand navbar-dark bg-dark">
	<div class="container">
		<div class="navbar-header">
			<a class="navbar-brand" href ="../main/welcome.jsp">Home</a>
		</div>
		<div>
			<ul class="navbar-nav mr-auto">
				<li style="padding-top: 7px; color: white">[<%=sessionAdminName %>님]</li>
				<li class="nav-item"><a class="nav-link" href="<c:url value="./logoutAdmin.jsp"/>">로그아웃</a></li>
				<li class="nav-item"><a class="nav-link" href="<c:url value="./updateAdmin.jsp"/>">정보 수정</a></li>
				<li class="nav-item"><a class="nav-link" href="<c:url value="./memberList.jsp"/>">회원 목록</a></li>
				<li class="nav-item"><a class="nav-link" href="./addProduct.jsp">상품 등록</a></li>
				<li class="nav-item"><a class="nav-link" href="./editProduct.jsp?edit=update">상품 수정</a></li>
				<li class="nav-item"><a class="nav-link" href="./editProduct.jsp?edit=delete">상품 삭제</a></li>
			</ul>
		</div>
	</div>
</nav>

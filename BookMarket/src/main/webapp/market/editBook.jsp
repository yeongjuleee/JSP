<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.ArrayList" %>
<%@ page import="bookstore.dto.Book" %>
<%@ page import="bookstore.dao.BookRepository" %>
<%@ page import="java.sql.*" %>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css">
<meta charset="UTF-8">
<title>도서 편집</title>
<script type="text/javascript">
	function deleteConfirm(id) {
		if (confirm("해당 도서를 삭제합니다!!") == true)
			location.href = "./deleteBook.jsp?id=" + id;
		else
			return;
	}
</script>
</head>
<%
	String edit = request.getParameter("edit");
	// 파라미터(값) 받는 부분
%>
<body>
	<jsp:include page="menu.jsp" />
	<div class="jumbotron">
		<div class="container">
			<h1 class="display-3">도서 편집</h1>
		</div>
	</div>
	
	<div class="container">
		<div class="text-right">
			<a href="logout.jsp" class="btn btn-sm btn-success pull-right">logout</a>
		</div>
	</div>
	
	<div class="container">
	<%@ include file="dbconn.jsp" %>
		<div class="row" align="center">
			<% 
				String sql = "select * from bookstore";
				pstmt = conn.prepareStatement(sql);
				rs = pstmt.executeQuery();
				while (rs.next()) {
			%>
			<div class="col-md-12">
				<img src="${pageContext.request.contextPath}/resources/images/<%=rs.getString("b_fileName")%>"
				style = "width: 300px" alt="">
				<h3><%=rs.getString("b_name") %></h3>
				<p><%=rs.getString("b_Publisher") %>
				<p><%=rs.getString("b_category")%></p>
				<p><%=rs.getString("b_UnitPrice") %>원</p>
					<%
						if(edit.equals("update")) {						
					%>
					<a href="./updateBook.jsp?id=<%=rs.getString("b_id")%>" class="btn btn-success" role="button">
					수정 &raquo;</a>
					<% 
						} else if (edit.equals("delete")) {
							
					%>
					<a href="#" onclick="deleteConfirm('<%=rs.getString("b_id") %>')" class="btn btn-danger" role="button">
					삭제 &raquo;</a>
					<% 
						}
					%>
			</div>
			<% 
				}
				
				if (rs != null)
					rs.close();
				if (pstmt != null)
					pstmt.close();
				if (conn != null)
					conn.close();
			%>
		</div>
		<hr>
	</div>
	<jsp:include page="footer.jsp" />
</body>
</html>
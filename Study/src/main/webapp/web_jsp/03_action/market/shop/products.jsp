<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.ArrayList" %>
<%@ page import="market.dto.Product" %>
<%@ page import="market.dao.ProductRepository" %>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css">
<meta charset="UTF-8">
<title>상품목록</title>
</head>
<body>
	<jsp:include page="../inc/menu.jsp" />
	<div class="jumbotron">
		<div class="container">
			<h1 class="display-3">상품목록</h1>
		</div>
	</div>
	
	<div class="container">
	<%@ include file="../inc/dbconn.jsp" %>
		<div class="row" align="center">
			<% 
				String sql = "select * from product";
				pstmt = conn.prepareStatement(sql);
				rs = pstmt.executeQuery();
				while (rs.next()) {
			%>
			<div class="col-md-4">
				<img src="c:/upload/<%=rs.getString("p_fileName")%>"
				style = "width: 300px" alt="">
				<img src="${pageContext.request.contextPath}/resources/images/<%=rs.getString("p_fileName")%>"
            	style = "width: 300px" alt="">
				<h3><%=rs.getString("p_name")%></h3>
				<p><%=rs.getString("p_description") %></p>
				<p><%=rs.getString("p_UnitPrice") %>원
				<p><a href="./product.jsp?id=<%=rs.getString("p_id")%>" class="btn btn-secondary" role="buntton">
				상세 정보 &raquo;</a></p>
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
	<jsp:include page="../inc/footer.jsp" />
</body>
</html>
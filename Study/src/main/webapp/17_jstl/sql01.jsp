<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JSTL</title>
</head>
<body>
	<%--
		<sql:query>태그로 SELECT 쿼리문 실행하기
		
		데이터베이스를 연결하기 위한 기본 설정을 하도록 <sql:setDataSource>문 작성
	 --%>
	 <sql:setDataSource var="dataSource"
	 	url="jdbc:mariadb://localhost:3308/member"
	 	driver="org.mariadb.jdbc.Driver" user="root" password="0732" />
	 	
 	<%-- member 테이블의 모든 필드 값을 가져오도록 <sql:query>태그 작성 --%>
 	<sql:query var="resultSet" dataSource="${dataSource}">
 		select * from member
 	</sql:query>
 	
 	<table border="1">
 		<tr>
 			<%-- SELECT문으로 가져온 필드 이름이 있을 떄까지 반복하도록 
 				 <c:forEach> 태그를 작성하고, <c:out> 태그로 필드 이름을 출력
 			 --%>
 			 
 			 <c:forEach var="columnName" items="${resultSet.columnNames }">
 			 	<th width="100"><c:out value="${columnName }" /></th>
 			 </c:forEach>
 		</tr>
 		
 		<%-- SELECT 문으로 가져온 레코드가 있을때까지 
 			 id, passwd, name 필드 값을 가져와 출력하도록 <c:forEach>태그로 반복하여 실행
 		 --%>
 		 <c:forEach var="row" items="${resultSet.rowsByIndex}">
 		 	<tr>
 		 		<c:forEach var="column" items="${row }" varStatus="i">
 		 		<td>
 		 			<c:if test="${column != null }" >
 		 				<c:out value="${column }" />
 		 			</c:if>
 		 			<c:if test="${column == null }" >
 		 				&nbsp;
 		 			</c:if>
 		 		</td>
 		 		</c:forEach>
 		 	</tr>
 		 </c:forEach>
 	</table>
</body>
</html>
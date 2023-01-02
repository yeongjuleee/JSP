<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Database SQL_select01</title>
</head>
<body>
	<%@ include file = "dbconn.jsp" %>
	<table width="300" border="1">
		<tr>
			<th>아이디</th>
			<th>비밀번호</th>
			<th>이름</th>
		</tr>

		<%--
			Statement 객체를 이용하여 SELECT 쿼리문 실행 결과 값 가져오기
		 --%>
		<%
			// ResultSet, Statement 참조 변수를 null로 초기화
			ResultSet rs = null;
			Statement stmt = null;
			
			try {
				// member 테이블의 모든 필드 값을 가져오도록 SELECT 문을 작성
				String sql = "select * from member";
				
				// Statement 객체를 생성하도록 작성
				stmt = conn.createStatement();
				
				// SELECT 문을 실행하도록 Statement 객체의 executeQuery() 메소드 작성
				rs = stmt.executeQuery(sql);
				
				// SELECT 문으로 가져온 레코드가 있을 떄까지 id, passwd, name 필드 값을 가져와 출력하도록 반복 실행
				while (rs.next()) {
					String id = rs.getString("id");
					String pw = rs.getString("passwd");
					String name = rs.getString("name");
			
		%>	
		<tr>
			<td><%=id%></td>
			<td><%=pw%></td>
			<td><%=name%></td>
		</tr>
		<%
				}
			} catch (SQLException ex) {
				out.println("Member 테이블 호출이 실패했습니다 <br>");
				out.println("SQLExcepiton : " + ex.getMessage());
			} finally {
				// 생성한 객체를 해제
				if (rs != null) rs.close();
				if (stmt != null) stmt.close();
				if (conn != null) conn.close();
			}
		%>
	</table>
</body>
</html>
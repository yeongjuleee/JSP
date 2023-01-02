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
	<table width="500" border="1">
		<tr>
			<th>학번</th>
			<th>학과</th>
			<th>이름</th>
			<th>주소</th>
			<th>연락처</th>
		</tr>

		<%--
			Statement 객체를 이용하여 SELECT 쿼리문 실행 결과 값 가져오기
		 --%>
		<%
			// ResultSet, Statement 참조 변수를 null로 초기화
			ResultSet rs = null;
			PreparedStatement pstmt = null;
			
			try {
				// student 테이블의 모든 필드 값을 가져오도록 SELECT 문을 작성
				String sql = "select * from student";
				
				// Statement 객체를 생성하도록 작성
				pstmt = conn.prepareStatement(sql);
				
				// SELECT 문을 실행하도록 Statement 객체의 executeQuery() 메소드 작성
				rs = pstmt.executeQuery();
				
				// SELECT 문으로 가져온 레코드가 있을 떄까지 id, passwd, name 필드 값을 가져와 출력하도록 반복 실행
				while (rs.next()) {
					String num = rs.getString("num");
					String depart = rs.getString("depart");
					String name = rs.getString("name");
					String address = rs.getString("address");
					String phone = rs.getString("phone");
			
		%>	
		<tr>
			<td><%=num%></td>
			<td><%=depart%></td>
			<td><%=name%></td>
			<td><%=address%></td>
			<td><%=phone%></td>
		</tr>
		<%
				}
			} catch (SQLException ex) {
				out.println("Member 테이블 호출이 실패했습니다 <br>");
				out.println("SQLExcepiton : " + ex.getMessage());
			} finally {
				// 생성한 객체를 해제
				if (rs != null) rs.close();
				if (pstmt != null) pstmt.close();
				if (conn != null) conn.close();
			}
		%>
	</table>
</body>
</html>
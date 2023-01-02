<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import ="java.sql.*" %>
<%@ include file="dbconn.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>DataBase_Sql Update</title>
</head>
<body>
	<%--
	PreparedStatement 객체를 이용하여 DELECT 쿼리문 실행 결과 값 가져오기
		=> PreparedStatement 를 이용하면 ? 를 사용할 수 있음
	 --%>
	 
	 <%
	 	request.setCharacterEncoding("utf-8");
	 
	 	String id = request.getParameter("id");
	 	String passwd = request.getParameter("passwd");
	 	
	 	// ResultSet, PreparedStatement 참조 변수를 null로 초기화
	 	PreparedStatement pstmt = null;
	 	ResultSet rs = null; 
	 	
	 	try {
	 		// member 테이블의 폼 페이지에서 전송된 id와 일치하는 레코드를 찾아 id, passwd 필드 값을 가져오도록 SELECT 문 작성
	 		String sql = "select id, passwd from member where id = ?";
	 		
	 		// PreparedStatement 객체를 생성하도록 prepareStatement() 메소드 작성
	 		pstmt = conn.prepareStatement(sql);
	 		
	 		
	 		// 물음표에 해당하는 값을 설정하도록 setString() 메소드 작성
	 		pstmt.setString(1, id);
	 		
	 		// SELECT 문을 실행하도록 PreparedStatement 객체의 executeQuery() 메소드 작성
	 		rs = pstmt.executeQuery();
	 		
	 		// SELCET 문으로 가져온 레코드가 있으면 실행
	 		if (rs.next()) {
	 			String rId = rs.getString("id");
	 			String rPasswd = rs.getString("passwd");
	 			
	 			if (id.equals(rId) && passwd.equals(rPasswd)) {
	 				// member 테이블에서 폼 페이지로부터 전송된 id와 일치하는 레코드를 찾아
	 				// name 필드 값을 변경하도록 UPDATE문 작성
	 				sql = "delete from member where id = ?";
	 				
	 				// PreparedStatement 객체를 생성하도록  prepareStatement() 메소드 작성
	 				pstmt = conn.prepareStatement(sql);
	 				
	 				// 물음표에 해당하는 값을 설정하도록 setString() 메소드 작성
	 				pstmt.setString(1, id);
	 				
	 				// DELECT 문을 실행하도록 Statement 객체의 exectueUpdate() 메소드 작성
	 				pstmt.executeUpdate();
	 				out.println("Member 테이블을 삭제했습니다.");
	 			} else
	 				out.println("일치하는 비밀번호가 아닙니다.");
	 		} else 
	 			out.println("Member 테이블에 일치하는 아이디가 없습니다.");
	 	} catch (SQLException ex) {
	 		out.println("SQLException : " + ex.getMessage());
	 	} finally {
	 		if (rs != null)
	 			rs.close();
	 		if (pstmt != null)
	 			pstmt.close();
	 		if (conn != null)
	 			conn.close();
	 	}
	 %>
</body>
</html>
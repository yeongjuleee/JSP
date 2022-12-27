<%@ page import="java.sql.PreparedStatement" %>
<%@ page import="java.sql.SQLException" %>
<%@ include file="conn_db.jsp" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
	request.setCharacterEncoding("UTF-8");
	
	String num = request.getParameter("num");
	
	String tableName = "todo_list";
	Statement statement = null;
	
	// 완료된 항목 리스트 & 데이터 베이스 삭제하기 (기본)
	//String sql = " DELETE FROM " + tableName + " WHERE num = " + num;
	
	// 완료된 항목 삭제하기 및 isChecked 값 false > true로 변경하기.
	// 값 변경이기 때문에 UPDATE 사용. UPDATE가 오면 SET 으로 설정해야함.
	// UPDATE 테이블명 SET 바꿀컬럼='바꿀값' WHERE(=조건임) 사라지는 애들
	String sql = " UPDATE " + tableName + " SET isChecked = 'true' WHERE num = " + num;
	
	statement = conn.createStatement();
	int resultInt = statement.executeUpdate(sql);
	
%>
{ "delete" : "true", "num" : <%=num%> }
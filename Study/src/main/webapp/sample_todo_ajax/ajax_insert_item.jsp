<%@ page import="java.sql.PreparedStatement" %>
<%@ page import="java.sql.SQLException" %>
<%@ include file="conn_db.jsp" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    /*전달 받은 글을 저장하고, 저장된 열의 num(자동증가 값, 데이터의 식별자)를 json으로 전달.*/
    request.setCharacterEncoding("UTF-8");
    
    String item = request.getParameter("item");
    
    String tableName = "todo_list";
    int num =0;
    Statement statement =null;
    
    String sql ="INSERT INTO " +tableName + "(item, insertDate) VALUES ('" + item + "', now())";
    statement= conn.createStatement();
    statement.executeUpdate(sql);
    
    /*getGeneratedKeys()가 안되어서 최신글 들고 오도록 수정
    ResultSet generatedKeys = statement.getGeneratedKeys();
    out.print(generatedKeys.getInt(1));*/
    //저장된 글의 번호를 들고 옴. 삭제시 데이터의 식별을 위해서
    sql ="SELECT num FROM " + tableName + " ORDER BY num DESC LIMIT 0,1";
    ResultSet resultSet = statement.executeQuery(sql);
    if(resultSet.next()){
       num = resultSet.getInt(1);
    }
    if(statement != null)
       statement.close();
    if(conn != null)
       conn.close();
    %>
    {"insert" : "true", "num" : <%=num%>}
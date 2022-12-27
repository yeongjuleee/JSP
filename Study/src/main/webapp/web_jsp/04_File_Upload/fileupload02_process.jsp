<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.oreilly.servlet.*"%>
<%@ page import="com.oreilly.servlet.multipart.*"%>
<%@ page import="java.util.*"%>
<%@ page import="java.io.*"%>
<!doctype html>
<head>
   <meta charset="utf-8">
   <title>file upload</title>
</head>
<body>
<%--
   MultipartRequest 클래스를 이용하여 여러 파일 업로드 및 정보 출력
 --%>
 <%
    MultipartRequest multi = new MultipartRequest(request, "C:\\upload",5*1024*1024,"utf-8",
         new DefaultFileRenamePolicy());
    
   String name1 = multi.getParameter("name1");
   String subject1 = multi.getParameter("subject1");
   
   String name2 = multi.getParameter("name2");
   String subject2 = multi.getParameter("subject2");
   
   String name3 = multi.getParameter("name3");
   String subject3 = multi.getParameter("subject3");
   
   String filename1 = multi.getFilesystemName("filename1");
   String filename2 = multi.getFilesystemName("filename2");
   String filename3 = multi.getFilesystemName("filename3");
   
 %>
 <table border="1">
    <tr>
       <th width="100">이름</th>
       <th width="100">제목</th>
       <th width="100">파일</th>
    </tr>
    <tr>
       <td><%=name1 %></td>
       <td><%=subject1%></td>
       <td><%=filename1 %></td>
    </tr>
    <tr>
       <td><%=name2 %></td>
       <td><%=subject2%></td>
       <td><%=filename2 %></td>
    </tr>
    <tr>
       <td><%=name3 %></td>
       <td><%=subject3%></td>
       <td><%=filename3 %></td>
    </tr>
       
 </table>
</body>
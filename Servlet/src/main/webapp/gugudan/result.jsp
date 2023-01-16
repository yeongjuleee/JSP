<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>구구단 결과</title>
</head>
<body>
   <h2>구구단 결과</h2>
   <hr>
   <%
   		int n = Integer.parseInt(request.getParameter("n"));
   		int [] aa = (int[])request.getAttribute("result");
   		for (int i = 0; i < 9; i++) {
   			out.println(n + " X " + (i + 1) + " = " + aa[i] + "<br>");
   		}
   %>
</body>
</html>
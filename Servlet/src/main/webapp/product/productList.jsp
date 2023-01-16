<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
<head>
<meta charset="UTF-8">
<title>상품 목록</title>
</head>
<body>
   <!-- 
   뷰 구현 : productList.jsp
    -->
   <h2>상품 목록</h2>
   <hr>
   <table border = "1">
      <tr>
          <th>번호</th>
          <th>상품명</th>
          <th>가격</th>
       </tr>
      <!-- products 라는 이름의 리스트 형식으로 데이터가 전달된다고 가정하면
      링크에는 action과 id 파라미터를 전달 -->
   <c:forEach var = "product" varStatus="i" items="${products}">
      <tr>
         <!-- 번호와 상품명, 가격 출력 -->
         <td>${i.count}</td>
         <td><a href="../product/productController?action=info&id=${product.id }">${product.name }</a></td>
         <td>${product.price }</td>
      </tr>
   </c:forEach>
   </table>
</body>
</html>
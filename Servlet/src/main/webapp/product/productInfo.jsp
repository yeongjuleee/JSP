<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>상품 정보 조회</title>
</head>
<body>
   <h2>상품 정보 조회</h2>
   <hr>
   <ul>
      <!-- product라는 이름으로 request scope object에 속성으로 저장된
      Product 클래스 타입의 객체의 멤버 변수 값 출력      
       -->
       <li>상품 코드 : ${product.id } </li>
       <li>상품명 : ${product.name } </li>
       <li>제조사 : ${product.maker } </li>
       <li>가격 : ${product.price } </li>
       <li>등록일 : ${product.date } </li>
   </ul>
</body>
</html>
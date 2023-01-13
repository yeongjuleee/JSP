<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div align="center">
		<h2>주소록 : 작성화면</h2>
		<hr>
		<a href=./address_book_control.jsp?action=list>주소록 목록으로</a> <br>
		<form name="frmInsert" method="post" action="./controller.do">
			<input type="hidden" name="action" value="insert">
			
			<table border="1">
				<tr>
					<th>이 름</th>
					<td><input type="text" name="name" maxlength="15"></td>
				</tr>
				
				<tr>
					<th>email</th>
					<td><input type="email" name="email" maxlength="50"></td>
				</tr>
				
				<tr>
					<th>전화번호</th>
					<td><input type="text" name="tel" maxlength="20"></td>
				</tr>
				
				<tr>
					<th>생 일</th>
					<td><input type="date" name="birth"></td>
				</tr>
				
				<tr>
					<th>회 사</th>
					<td><input type="text" name="comdept" maxlength="20"></td>
				</tr>
				
				<tr>
					<th>메 모</th>
					<td><input type="text" name="memo"></td>
				</tr>
				
				<tr>
					<td colspan=2 align=center>
						<input type="submit" value="저장">
						<input type="submit" value="취소">
					</td>
				</tr>
			</table>
		</form>
	</div>
</body>
</html>
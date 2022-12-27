<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>member_insert</title>
<script src="./member.js"></script>
<script src="https://spi.maps.daum.net/imap/map_js_init/postcode.v2.js"></script>
</head>
<body>
	<h2>회원가입</h2>
	<form action="member_insert_action.jsp" name="member_insert" method="post">
		<p>회원 아이디 : <input type="text" name="memberID"></p>
		<p>비밀번호	: <input type="password" name="passwd"></p>
		<p>비밀번호 확인: <input type="password" name="passwdCheck"></p>
		<p>이름		: <input type="text" name="memberName"></p>
		<p>이메일		: <input type="text" name="email"></p>
		<p>관심사항	: 영화<input type="checkbox" name="interest" value="영화">
					 독서<input type="checkbox" name="interest" value="독서">
					 수영<input type="checkbox" name="interest" value="수영">
					 등산<input type="checkbox" name="interest" value="등산"></p>
		<p>주소		:
					 <input name="zipcode" id="zipcode" size="10" maxlength="7" readonly>
                     <span onclick="execDaumPostcode();" style="cursor:pointer;">우편번호 검색</span><br />
                     <input name="address01" id="address01" size="70" maxlength="70" readonly> 
                     <input name="address02" id="address02" size="70" maxlength="70"></p>
       	<p>생년월일	: <input type="text" name="birthYear">
       				  <input type="text" name="birthMonth">
       				  <input type="text" name="birthDay"></p>
       	<p>메일 수신 여부: YES<input type="radio" name="mailYN" value="yes">
       					NO<input type="radio" name="mailYN" value="no"></p>
       	<p>문자 수신 여부:	YES<input  type="radio" name="smsYN" value="yes">
       					NO<input type="radio" name="smsYN" value="no"></p>
       	<p><input type="button" value="가입하기" onclick="checkMember()">
	</form>
	
	<!-- insert sql문 작성 -->
	<p>INSSERT INTO tTest VALUES('kkyu', 'jun9', 'jun9', '김준규', 'kkyu@treasuer.com', '영화','20087', '희우정로8길 7 9동 9호', '20000909', 'no', 'no'  )
</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<script src="https://spi.maps.daum.net/imap/map_js_init/postcode.v2.js"></script>
    <script>
        /* 
        카카오 우편번호 검색 가이드 페이지 :  https://postcode.map.daum.net/guide
        getElementById() : html 에서 매개변수로 받은 id 값이 있는 요소를 반환.
        */
        function execDaumPostcode() {
            new daum.Postcode({
                oncomplete: function(data) {
                    // 팝업에서 검색결과 항목을 클릭했을때 실행할 코드를 작성하는 부분.

                    // 각 주소의 노출 규칙에 따라 주소를 조합한다.
                    // 내려오는 변수가 값이 없는 경우엔 공백('')값을 가지므로, 이를 참고하여 분기 한다.
                    var fullAddr = ''; // 최종 주소 변수
                    var extraAddr = ''; // 조합형 주소 변수

                    // 사용자가 선택한 주소 타입에 따라 해당 주소 값을 가져온다.
                    if (data.userSelectedType === 'R') { // 사용자가 도로명 주소를 선택했을 경우
                        fullAddr = data.roadAddress;
                    }
                    else { // 사용자가 지번 주소를 선택했을 경우(J)
                        fullAddr = data.jibunAddress;
                    }

                    // 사용자가 선택한 주소가 도로명 타입일때 조합한다.
                    if(data.userSelectedType === 'R'){
                        //법정동명이 있을 경우 추가한다.
                        if(data.bname !== ''){
                            extraAddr += data.bname;
                        }
                        // 건물명이 있을 경우 추가한다.
                        if(data.buildingName !== ''){
                            extraAddr += (extraAddr !== '' ? ', ' + data.buildingName : data.buildingName);
                        }
                        // 조합형주소의 유무에 따라 양쪽에 괄호를 추가하여 최종 주소를 만든다.
                        fullAddr += (extraAddr !== '' ? ' ('+ extraAddr +')' : '');
                    }

                    // 우편번호와 주소 정보를 해당 필드에 넣는다.
                    document.getElementById('zipcode').value = data.zonecode; //5자리 새우편번호 사용
                    document.getElementById('address01').value = fullAddr;

                    // 커서를 상세주소 필드로 이동한다.
                    document.getElementById('address02').focus();
                }
            }).open();
        }
    </script> 
    
	<h2>form 태그를 이용하여 다음 조건에 맞게 JSP 애플리케이션을 만들고 실행 결과를 확인하시오.</h2>
	
	<p>
		1. formTest01.jsp 파일을 생성합니다. <br>
		-input 태그 내에 text 유형을 이용하여 이름, 주소, 이메일 항목을 작성합니다. <br>
		-form 태그의 action  속성 값은 formTest01_process.jsp로 작성합니다. <br><br>
		
		2. formTest01_process.jsp 파일을 생성합니다. <br>
		-request 내장 객체의 getParameter() 메소드를 이용하여 전송된 요청 파라미터 값을 받습니다.<br>
		-String을 이용하여 전송된 파라미터 값을 저장하여 출력합니다. <br>
	</p>
	
	<form action="./formTest01_process02.jsp" method="get">
		<p> 이   름 : <input type="text" name="name"></p>
		<p> 주   소 : 
					<input name="zipcode" id="zipcode" size="10" maxlength="7" readonly>
	                <span onclick="execDaumPostcode();" style="cursor:pointer;">우편번호 검색</span><br />
	                <input name="address01" id="address01" size="70" maxlength="70" readonly> 
	                <input name="address02" id="address02" size="70" maxlength="70">
		</p>
		<p> 이 메 일 : <input type="text" name="email"></p>
		<p> <input type="submit" value="전송">
	</form>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Form processing</title>
</head>
<body>
	<%
		// 요청 받은 정보를 utf-8로 인코딩함
		request.setCharacterEncoding("UTF-8");
	
		String id = request.getParameter("id");
		String passwd = request.getParameter("passwd");
		String name = request.getParameter("name");
		String phone1 = request.getParameter("phone1");
		String phone2 = request.getParameter("phone2");
		String phone3 = request.getParameter("phone3");
		String sex = request.getParameter("sex");
		
		//같은 이름으로 여러개가 있다면,
		String[] hobby = request.getParameterValues("hobby");
		//String hobby2 = request.getParameter("hobby2");
		//String hobby3 = request.getParameter("hobby3");
		String comment = request.getParameter("comment");
	%>
	
	<p>아 이 디 : <%=id%></p>
	<p>비밀 번호 : <%=passwd%></p>
	<p>이   름 : <%=name%></p>
	<p>연 락 처 : <%=phone1%>-<%=phone2%>-<%=phone3%></p>
	<p>성   별 : <%=sex%></p>
	<p>취   미 : 
		<% // 선택한 것이 나오게 하는 방법
			// values로 받아서 for문을 돌림(???)
			if(hobby != null) { // hobby가 안 비어있으면, 
				for(int i = 0; i < hobby.length; i++) { // 하비의 길이(=체크한 수)만큼 i(hobby의 index값) 증가.
					out.println(" " + hobby[i]); // hobby[인덱스 번호] 출력
				}
			}
		%>
		<%--<%=hobby--%>
		</p>
	<p>가입 인사 : <%=comment%></p>
</body>
</html>
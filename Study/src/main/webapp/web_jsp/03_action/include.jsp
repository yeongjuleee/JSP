<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Action Tag</title>
</head>
<body>
	<%--
	include : �ٸ� �������� ���� �������� �����ϰ��� �� �� ���. 
		JSP �ۼ� �� �ٸ� �������� �����ϴ� �� �ٸ� ��� : <%@ include file="" %> ��� 
		
		
	include �׼� �±׿� ���� ��¥�� �ð��� ����ϴ� ������ �����ϱ�
	�ܺ� ���� include_date.jsp�� ������ �����Ͽ� ����ϵ��� include �׼� �±��� page �Ӽ��� �ۼ� --%>
	
	<h2>include �׼� �±�</h2>
	<jsp:include page="include_date.jsp" flush="true" />
	<p>----------------------------------</p>
</body>
</html>
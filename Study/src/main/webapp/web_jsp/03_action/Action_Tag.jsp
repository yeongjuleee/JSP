<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Action Tag</title>
</head>
<%--
	 ǥ�� �׼� �±�?
	 �̸� ������ ��ɵ��� JSP ���忡 ��� => ��� �����̳ʰ� �����ϰ� �����ϴ� �±�
	 ��� JSP �����̳ʿ��� �⺻���� �����ϰ� �־ �⺻ �׼� �±׶�� ��.
 --%>

<body>
	<%-- 
	forward : �ٸ� �������� �̵��� �� ����ϴ� �±�
	forward �׼� �±׷� ���� ��¥�� �ð��� ����ϴ� �������� �̵��ϱ�.
	1. �ܺ� ���� forward_date.jsp �� ������ ����ϵ��� forward �׼� �±��� page �Ӽ��� �ۼ� --%>
	
	<h2>forward �׼� �±�</h2>
	<jsp:forward page="forward_date.jsp" />
	<p>---------------------------------</p>
</body>
</html>
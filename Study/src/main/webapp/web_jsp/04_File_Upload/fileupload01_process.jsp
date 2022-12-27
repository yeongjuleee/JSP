<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.oreilly.servlet.*"%>
<%@ page import="com.oreilly.servlet.multipart.*" %>
<%@ page import="java.util.*" %>
<%@ page import="java.io.*" %>

<%-- 
	MultipartRequest 클래스를 이용하여 파일 업로드 및 정보 출력하기
	1. MultipartRequest 클래스를 사용하도록 page 디렉티브 태그의 import 속성 값에 패키지 com.oreilly.servlet.* 작성
	2. DefaultFileRenamePolicy 클래스를 사용하도록 page 디렉티브 태그의 import 속성 값에 패키지 com.oreilly.servlet.multipart.* 작성
	3. MultipartRequest 클래스를 생성하도록 서버 파일 경로는 "C:\\upload",
	   -파일 최대 크기는 5MB(5 * 1024 * 1024B)이고,
	   -파일명의 인코딩 유형은 utf-8
	   -서버에 저장된 파일명 중복 처리를 위해 DefaultFileRenamePolicy 클래스 사용
	   -서버에 동일한 파일이 존재하면 전송된 파일명 뒤에 숫자를 덧붙여 파일명이 중복되지 X --%>
	   
<%
	MultipartRequest multi = new MultipartRequest(request, "C:\\upload", 5 * 1024 * 1024, "utf-8",
							 new DefaultFileRenamePolicy());
	
	Enumeration params = multi.getParameterNames();
	
	while (params.hasMoreElements()) {
	String name = (String)params.nextElement();
	String value = multi.getParameter(name);
	out.println(name + " = " + value + "<br>");
	}
	out.println("---------------------------------------<br>");
	
	// 폼 페이지에서 전송된 요청 파라미터 중 파일을 전달받도록 getFileNames() 메소드 작성
	Enumeration files = multi.getFileNames();
	
	/*
		getFilesystemName() : 폼 페이지에서 전송되어 서버에 업로드된 파일 이름 반환
		getOriginalFileName() : 폼 페이지에서 전송된 파일이 서버에 저장되기 전 파일 이름 반환
		getContentType() : 폼 페이지에서 전송된 파일의 컨텐츠 유형 반환
		getFile() : 폼페이지에서 전송된 파일 반호나
	*/
	
	while(files.hasMoreElements()) {
		String name = (String)files.nextElement();
		String filename=multi.getFilesystemName(name);
		String original = multi.getOriginalFileName(name);
		String type = multi.getContentType(name);
		File file = multi.getFile(name);
		
		out.println("요청 파라미터 이름 : " + name + "<br>");
		out.println("실제 파일 이름 : " + original + "<br>");
		out.println("저장 파일 이름 : " + filename + "<br>");
		out.println("파일 콘텐츠 타입 : " + type + "<br>");
		
		if(file != null) {
			out.println("파일 크기 : " + file.length());
			out.println("<br>");
		}
	}
%>
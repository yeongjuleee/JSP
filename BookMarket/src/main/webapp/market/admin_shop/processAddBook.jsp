<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="bookstore.dto.Book" %>
<%@ page import="bookstore.dao.BookRepository" %>
<%@ page import="java.util.*"%>
<%@ page import="java.io.File" %>
<%@ page import="com.oreilly.servlet.*" %>
<%@ page import="com.oreilly.servlet.multipart.*" %>
<%@ page import="java.sql.*" %>
<%@ include file="../inc/dbconn.jsp" %>

<% 
	request.setCharacterEncoding("UTF-8");

	//파일이 저장되는 경로
	String realPath = request.getServletContext().getRealPath("resources/images"); // 경로
	File dir = new File(realPath); 
	if (!dir.exists()) { // 파일이 저장되는 경로 resources/images가 없을 경우, 지정된 경로에 해당되는 디렉토리(=resource(폴더))가 존재하는지 확인
		dir.mkdirs(); // 해당되는 디렉토리가 없으면 만들기
	}
	
	String filename = "";
	String encType = "utf-8";	// 인코딩 타입
	int maxSize = 5 * 1024 * 1024;	// 최대 업로드 될 파일의 크기 5MB
	
	MultipartRequest multi = new MultipartRequest(request, realPath, maxSize, encType, new DefaultFileRenamePolicy());
	// DefalutFileRename~ : 동일한 이름이 있을 경우 이름 바꾸기
	
	
	String bookId = multi.getParameter("bookId"); // MultipartRequest하기 전에는 request.getParameter로 받았음
	String name = multi.getParameter("name");
	String unitPrice = multi.getParameter("unitPrice");
	String author = multi.getParameter("author");
	String description = multi.getParameter("description");
	String publisher = multi.getParameter("publisher");
	String category = multi.getParameter("category");
	String unitsInStock = multi.getParameter("unitsInStock");
	String totalPages = multi.getParameter("totallPages");
	String releaseDate = multi.getParameter("releaseDate");
	String condition = multi.getParameter("condition");
	
	Integer price;
	
	if(unitPrice.isEmpty())
		price = 0;
	else 
		price = Integer.valueOf(unitPrice);
	
	long stock;
	
	if (unitsInStock.isEmpty())
		stock = 0;
	else 
		stock = Long.valueOf(unitsInStock);
	
	long totalPage;
	
	if(totalPages.isEmpty())
		totalPage = 0;
	else 
		totalPage = Long.valueOf(totalPages);
	
	// 파일 처리되는 부분
	Enumeration files = multi.getFileNames();
	String fname = (String)files.nextElement();
	String fileName = multi.getFilesystemName(fname);
	
	/* 기존 부분
	BookRepository dao = BookRepository.getInstance();
	
	Book newBook = new Book();
	newBook.setBookId(bookId);
	newBook.setName(name);
	newBook.setUnitPrice(price);
	newBook.setAuthor(author);
	newBook.setDescription(description);
	newBook.setPublisher(publisher);
	newBook.setCategory(category);
	newBook.setUnitsInStock(stock);
	newBook.setTotallPages(totalPage);
	newBook.setReleaseDate(releaseDate);
	newBook.setCondition(condition);
	newBook.setFilename(fileName);
	
	dao.addBook(newBook);
	*/
	
	// db 연결부분 후 수정 부분
	String sql = "insert into bookstore values(?,?,?,?,?,?,?,?,?,?,?,?)";
	
	pstmt = conn.prepareStatement(sql);
	pstmt.setString(1, bookId);
	pstmt.setString(2, name);
	pstmt.setInt(3, price);
	pstmt.setString(4, author);
	pstmt.setString(5, description);
	pstmt.setString(6, publisher);
	pstmt.setString(7, category);
	pstmt.setLong(8, stock);
	pstmt.setLong(9, totalPage);
	pstmt.setString(10, releaseDate);
	pstmt.setString(11, condition);
	pstmt.setString(12, fileName);
	pstmt.executeUpdate();
	
	if (pstmt != null)
		pstmt.close();
	if (conn != null)
		conn.close();
	
	response.sendRedirect("../shop/bookstore.jsp");
%>


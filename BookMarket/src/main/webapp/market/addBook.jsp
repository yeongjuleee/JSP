<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css">
<script type="text/javascript" src="./resources/JS/validation.js"></script>
<meta charset="UTF-8">
<title>도서 등록</title>
</head>
<%--
	수정문제! (2022-12-26) : multipart 사용하기
	1) 생성된 BookMarket 프로젝트를 사용합니다.
	2) dao 폴더의 상품 클래스 Book을 수정합니다.
	   이미지 파일을 관리할 멤버 변수 필드를 선언하고 Setter / Getter() 메서드 작성하기를 작성합니다.
	3) 도서 데이터 접근 클래스 BookRepository의 기본 생성자에 도서 이미지를 설정하도록 추가 작성합니다.
	4) 정적 리소스 관리를 위해 정적 리소스 관리 폴더 resources를 생성합니다.
	- resources 폴더에 images 폴더를 생성.
	- 이 폴더에 도서 이미지 파일명을 도서 아이디로 등록합니다!
	5) webapp 폴더의 books.jsp, book.jsp 파일을 수정하고 도서 이미지를 출력하도록 수정합니다.
	6) 이미지를 웹 서버에 업로드하도록 작성합니다.
	- MultipartRequest 클래스를 이용한 파일 업로드를 위해 WEB-INF/lib 폴더에 cos.jar 파일을 등록합니다.
	-addBook.jsp 파일에 상품 이미지 파일을 업로드하도록 form 태그에 enctype 속성을 설정합니다.
	이미지 파일을 첨부하기 위한 input 태그를 추가 작성합니다.
	- 상품 등록 처리 페이지 processAddBook.jsp 파일에 도서 이미지 파일을 업로드하도록 MultipartRequest 클래스를 작성합니다.
	7) 웹브라우저에 실행결과를 확인합니다.
--%>
<body>
	<jsp:include page="menu.jsp" />
	<div class="jumbotron">
		<div class="container">
			<h1 class="display-3">도서 등록</h1>
		</div>
	</div>
	
	<div class="container">
		<div class="text-right">
			<a href="logout.jsp" class="btn btn-sm btn-success pull-right">logout</a>
		</div>
	</div>
	
	<div class="container">
		<form name="newBook" id="newBook" action="./processAddBook.jsp" class="form-horizontal" method="post"
		enctype="multipart/form-data">
			<div class="form-group row">
				<label class="col-sm-2">도서 아이디</label>
				<div class="col-sm-3">
					<input type="text" name="bookId" class="form-control" id="bookId">
				</div>
			</div>
			<div class="form-group row">
				<label class="col-sm-2">도서명</label>
				<div class="col-sm-3">
					<input type="text" name="name" class="form-control" id="name">
				</div>
			</div>
			<div class="form-group row">
				<label class="col-sm-2">가격</label>
				<div class="col-sm-3">
					<input type="text" name="unitPrice" class="form-control" id="unitPrice">
				</div>
			</div>
			<div class="form-group row">
				<label class="col-sm-2">저자</label>
				<div class="col-sm-3">
					<input type="text" name="author" class="form-control">
				</div>
			</div>
			<div class="form-group row">
				<label class="col-sm-2">설명</label>
				<div class="col-sm-5">
					<textarea name="description" class="form-contol" 
					rows="2" cols="50"></textarea>
				</div>
			</div>
			<div class="form-group row">
				<label class="col-sm-2">출판사</label>
				<div class="col-sm-3">
					<input type="text" name="publisher" class="form-control">
				</div>
			</div>
			<div class="form-group row">
				<label class="col-sm-2">분류</label>
				<div class="col-sm-3">
					<input type="text" name="category" class="form-control">
				</div>
			</div>
			<div class="form-group row">
				<label class="col-sm-2">재고 수</label>
				<div class="col-sm-3">
					<input type="text" name="unitsInStock" class="form-control" id="unitsInStock">
				</div>
			</div>
			<div class="form-group row">
				<label class="col-sm-2">페이지 수</label>
				<div class="col-sm-3">
					<input type="text" name="totallPages" class="form-control">
				</div>
			</div>
			<div class="form-group row">
				<label class="col-sm-2">출판일</label>
				<div class="col-sm-3">
					<input type="text" name="releaseDate" class="form-control">
				</div>
			</div>
			<div class="form-group fow">
				<label class="col-sm-2">상태</label>
				<div class="col-sm-5">
					<input type="radio" name="condition" value="New"> 신규 도서
					<input type="radio" name="condition" value="Old"> 중고 도서
					<input type="radio" name="condition" value="E-book"> E-book
				</div>
			</div>
			<div class="form-group row">
				<label class="col-sm-2">이미지</label>
					<div class="col-sm-5">
						<input type="file" name="bookImage" class="form-control">
					</div>
			</div>
			<div class="form-group row">
				<div class="col-sm-offset-2 col-sm-10">
					<input type="button" class="btn btn-primary" value="등록" onclick="CheckAddBook()">
				</div>
			</div>
		</form>
	</div>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<meta name="viewport"
		content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
	<meta http-equiv="X-UA-Compatible" content="ie=edge">
<title>File Upload</title>
</head>
<body>
	<form name="fileForm" method="post" enctype="multipart/form-data" action="fileupload01_process.jsp">
		<p>이 름 : <input type="text" name="name"></p>
		<p>제 목 : <input type="text" name="subject"></p>
		<p>파 일 : <input type="file" name="filename"></p>
		<p><input type="submit" value="파일 올리기"></p>
	</form>
</body>
</html>
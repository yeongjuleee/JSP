<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%@ page import="mvc.model.BoardDTO" %>

<%
	BoardDTO notice = (BoardDTO) request.getAttribute("board");
	int num = ((Integer) request.getAttribute("num")).intValue();
	int nowpage = ((Integer) request.getAttribute("page")).intValue();			
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="../resources/css/bootstrap.min.css" />
<title>Board</title>
<script type="text/javascript">
	let delPost = function() {
		const frm = document.newUpdate;
		if(confirm ("선택한 게시물을 삭제하시겠습니까?")) {
			frm.action = "./BoardDeleteAction.do";
			frm.submit();
		}
	}

</script>
</head>
<body>
	<jsp:include page="../inc/menu.jsp" />
		<div class="jumbotron">
			<div class="container">
				<h1 class="display-3">게시판</h1>
			</div>
		</div>
		
		<div class="container">
			<form name ="newUpdate"
			 action="BoardUpdateAction.do?num=<%=notice.getNum() %>&pageNum=<%=nowpage %>"
			class="form=horizontal" method="post">
				<input type="hidden" name = "num" value="<%=notice.getNum()%>">
				<input type="hidden" name="pageNum" value="<%=nowpage %>">
				<div class="form-group row">
					<label class="col-sm-2 control-label">성명</label>
					<div class="col-sm-3">
						<input name="name" class="form-control" value="<%=notice.getName() %>" readonly>
					</div>
				</div>
				<div class="form-group row">
					<label class="col-sm-2 control-label">제목</label>
					<div class="col-sm-5">
						<input name="subject" class="form-control" value="<%=notice.getSubject() %>" readonly>
					</div>
				</div>
				<div class="form-group row">
					<label class="col-sm-2 control-label">내용</label>
					<div class="col-sm-8" style="word-break: break-all">
						<textarea name="content" cols="50" rows="5" class="form-control" readonly><%=notice.getContent() %></textarea>
					</div>
				</div>
				<div class="form-group row">
               <div class="col-sm-offset-2 col-sm-10">
	               <c:set var ="userId" value="<%=notice.getId() %>"/>
	               <c:if test = "${sessionId==userId }">
	                  <p>
	                     <span class="btn btn-danger" onclick="delPost()">삭제</span>
	                     <input type="submit" class="btn btn-success" value="수정">
	               </c:if>
	               <a href="./BoardListAction.do?pageNum=<%=nowpage %>" class="btn btn=primary">목록</a>
	               </div>
	            </div>
			</form>			
		</div>
		<jsp:include page="../inc/footer.jsp" />
</body>
</html>
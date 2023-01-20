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
	let goUpdate = function() {
		const frm = document.newUpdate;
		frm.action = "./BoardUpdateForm.do";
		frm.submit();
	}
	
	let goDel = function() {
		const frm = document.newUpdate;
		if(confirm ("선택한 게시물을 삭제하시겠습니까?")) {
			frm.action = "../boardController/BoardDeleteAction.do";
			frm.submit();
		}
	}
	
	function goRippleDelete(ID) {
		if (confirm("삭제하시겠습니까?")) {
			const frm = document.frmRippleDelete;
			frm.rippleId.value = ID;
			frm.action = "BoardRippleDeleteAction.do";
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
				<div class="form-group row">
					<label class="col-sm-2 control-label">성명</label>
					<div class="col-sm-3">
						<%=notice.getName() %>
						<hr>
					</div>
				</div>
				<div class="form-group row">
					<label class="col-sm-2 control-label">제목</label>
					<div class="col-sm-5">
						<%=notice.getSubject() %>
						<hr>
					</div>
				</div>
				<div class="form-group row">
					<label class="col-sm-2 control-label">내용</label>
					<div class="col-sm-8" style="word-break: break-all">
						<%=notice.getContent() %>
						<hr>
					</div>
				</div>
				<div class="form-group row">
               <div class="col-sm-offset-2 col-sm-10">
	               <c:set var ="userId" value="<%=notice.getId() %>"/>
	               <c:if test = "${sessionId==userId }">
	                  <p>
	                     <span class="btn btn-danger" onclick="goDel()">삭제</span>
	                     <span class="btn btn-success" onclick="goUpdate()">수정</span>
	               </c:if>
	               <a href="./BoardListAction.do?pageNum=<%=nowpage %>" class="btn btn-primary">목록</a>
	               </div>
	            </div>
			<form name ="newUpdate" method="post">
				<input type="hidden" name = "num" value="<%=notice.getNum()%>">
				<input type="hidden" name="pageNum" value="<%=nowpage %>">	
			</form>	
		</div>
		
		<!-- 리플 목록 -->
		<hr>
		<div class="container">
		<c:forEach var="ripple" items="${rippleList}" >
			<p>${ripple.content} | ${ripple.name}
				<c:if test="${sessionId == ripple.memberId }">
					<span class="btn btn-danger" onclick = "goRippleDelete('${ripple.rippleId}');">삭제</span>
				</c:if>
			</p>
		</c:forEach>
		</div>
		
		<form name="frmRippleDelete" class="form-horizontal" method="post">
			<input type="hidden" name="num" value="<%=notice.getNum() %>">
			<input type="hidden" name="pageNum" value="<%=nowpage%>">
			<input type="hidden" name="rippleId">
		</form>
		
		
      <!-- 리플 쓰기는 로그인 상태에서만 나옴 -->
      <hr>
      <div class="container">
      <c:if test="${sessionId != null }">
      <form name="frmRipple" class="form-horizontal" method="post">
	      <input type="hidden" name="num" value="<%=notice.getNum() %>">
	      <input type="hidden" name="pageNum" value="<%=nowpage %>">
	      <div class="form-group row">
	         <label class="col-sm-2 control-label">성명</label>
		         <div class="col-sm-3">
		            <input name="name" type="text" class="form-control" value="${sessionName}" placeholder="name">
		         </div>      
	      </div>
      <div class="form-group row">
         <label class="col-sm-2 control-label">내용</label>
         <div class="col-sm-8" style="word-break: break-all;">
            <textarea name="content" class="form-control" cols="50" rows="3"></textarea>
         </div>      
      </div>
      <div class="form-group row">
         <label class="col-sm-2 control-label"></label>
         <div class="col-sm-3">
            <span class="btn btn-primary" onclick="goRippleSubmit();">등록</span>
         </div>      
      </div>
      </form>
      <script>
         function goRippleSubmit() {
            let frm = document.frmRipple;
            frm.action = "RippleWriteAction.do";
            frm.submit();
         }
      </script>
      </c:if>
      <!-- 리플 쓰기 -->
      <div class="form-group row">
         <div class="col-sm-offset-2 col-sm-10">
            <c:set var="userId" value="<%=notice.getId() %>"/>
         </div>
      </div>
      </div>
		<jsp:include page="../inc/footer.jsp" />
</body>
</html>
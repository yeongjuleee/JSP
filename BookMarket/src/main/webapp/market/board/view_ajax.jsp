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

	//리플
	const xhr = new XMLHttpRequest();   //XMLHttpRequest 객체 생성
	document.addEventListener("DOMContentLoaded", function() {
		
	   
		document.querySelector('span[name=goRippleSubmit]').addEventListener('click', function() {
		   // 등록 버튼 클릭할 경우
		   // 1. DB에 데이터 등록
		   // 2. 화면에 표시
		   
		   let num = document.querySelector('input[name=num]');
		   let name = document.querySelector('input[name=name]');
		   let content = document.querySelector('textarea[name=content]');
		   
		   //xhr.open("POST", "../board/ajax_insert_content.jsp?boardName=board&num=" + 
			//	   num.value + "&name=" + name.value + "&content=" + content.value);
		   xhr.open("POST", "../boardController/RippleWriteAction.do?boardName=board&num=" + 
		    		num.value + "&name=" + name.value + "&content=" + content.value);
		   xhr.send();
		   xhr.onreadystatechange = () => {
			   if (xhr.readyState !== XMLHttpRequest.DONE) return;
			   
			   if (xhr.status === 200) {	// 서버 (url)에 문서가 존재O
				    console.log(xhr.response);
			   		const json = JSON.parse(xhr.response);
			   		if (json.result === 'true') {
			   			content.value = "";	// input 태그에 입력된 값 삭제
			   			insertList();
			   		}
			   		else {
			   			alert("등록에 실패했습니다.");
			   		}
			   }
			   else {	// 서버에 (url) 문서가 존재X
				   console.error('Error', xhr.status, xhr.statusText);
			   }
		   }
		   
	   });
	});	   
	
   // 함수 선언
   const insertItem = function(item) {
	  // 목록에 요소를 추가. 처음 로딩할 경우 목록을 출력하거나 새로운 글 등록시 사용
	  let tagNew = document.createElement('li');
	  tagNew.innerHTML = item.content + " | " + item.name;
	  if (item.isWriter === 'true') {
		tagNew.innerHTML += '<span class="btn btn-danger" onclick="goRippleDelete(\'' + item.rippleId + '\');">>삭제</span>';
	  }
	  let tagUl = document.querySelector('.user-repple-list ul');
	  tagUl.append(tagNew);
   }
   
   const insertList = function() {
      //목록을 가지고 오기
      let num = document.querySelector('form[name=frmRippleDelete] input[name=num]');
      //xhr.open('GET','../board/ajax_list_item.jsp?boardName=board&num='+ num.value);
      xhr.open('GET','../boardController/RippleListAction.do?boardName=board&num='+ num.value);
      xhr.send();
      xhr.onreadystatechange = function() {
         if (xhr.readyState !== XMLHttpRequest.DONE) return;
         
         if (xhr.status === 200) {   //서버(url)에 문서가 존재하면
            console.log(xhr.response);
         	const json = JSON.parse(xhr.response);
         
            let tagUl = document.querySelector('.user-repple-list ul');
            console.log(tagUl);
            tagUl.innerHTML = "";   //내부 태그 삭제후 인서트
            
            for (let data of json.listData) {
               console.log(data);
               insertItem(data);
            }
            
         } else {
            //서버에 문서가 존재하지 않음
            console.error('Error', xhr.status, xhr.statusText);
         }
      }
   }
   
   // 리플 삭제
   const goRippleDelete = function(ID) {
	   if (confirm("삭제하시겠습니까?")) {
		   const xhr = new XMLHttpRequest();	// XMLHttpRequest 객체 생성
		   //xhr.open('POST', '../board/ajax_delete.jsp?rippleId=' + ID);
		   xhr.open("POST", "../boardController/RippleDeleteAction.do?rippleId=" + ID);
		   xhr.send();
		   xhr.onreadystatechange = () => {
			   if(xhr.readyState !== XMLHttpRequest.DONE) return;
			   
			   if(xhr.status === 200) {// 서버(url)에 문서가 존재함 
				   console.log(xhr.response);
			   		const json = JSON.parse(xhr.response);	
				   if(json.result === 'true') { // true이면 목록이 갱신
					   insertList();
				   }
				   else {
					   alert("삭제에 실패했습니다.");
				   }
			   }
			   else { // 서버(url)에 문서가 존재하지 X 
				   console.error("Error", xhr.status, xhr.statusText);
			   }
		   }
	   }
   }

   document.addEventListener("DOMContentLoaded", function() {
      insertList();
   })

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
			<div class="form-group row user-repple-list">
				<ul>
				</ul>
      		</div>
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
            <span class="btn btn-primary" name="goRippleSubmit">등록</span>
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
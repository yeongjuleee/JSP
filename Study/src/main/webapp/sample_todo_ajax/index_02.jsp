<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<html>
<head>
<title>Title</title>
<style>
   *{ margin : 0; padding : 0;}
   ul { list-style :none;}
   body {margin : 20px auto; width : 400px;}
</style>
</head>

<body>
   <div class="insert">
      <form>
         <input type ="text" name="item">
         <input type ="button" value="등록" >
         <input type ="button" value="완료된 항목" name="done">
         <!-- <input type ="button" value="false" name="done">-->
      </form>
   </div>
   
   <!-- 목록이 들어갈 부분 -->
   <div id = "todo_list">
      <ul>
      </ul>
   </div>
   
<script>
   document.addEventListener("DOMContentLoaded", function(){
      //변수 선언
   const xhr = new XMLHttpRequest(); //XMLHttpRequest 객체 생성
   
   //함수선언
   const insertItem = function(num, item){
	  /*
	   if(item == null){
		  let tagNew = document.createElement('li');
	      tagNew.innerHTML = '<label>완료 항목이 존재하지 않습니다.</label>';
	      tagNew.setAttribute('class', num);
	   }else{
		 
	   }
	  */
	  
      //목록에 요소를 추가. 처음 로딩시 목록을 출력하거나, 새로운 글 등록시 사용
      let tagNew = document.createElement('li');
      tagNew.innerHTML = '<lable><input type = "checkbox" class="cb" name="' + num +'" value ="' + num + '"></lable>' + item;
      tagNew.setAttribute('class', num);
      //동적으로 생성된 요소에서 생성시에 이벤트 추가.
      tagNew.querySelector('input[type=checkbox]').addEventListener('click',deleteItem);
      let tagUl = document.querySelector('ul');
      tagUl.prepend(tagNew);
   }
   
   const insertList = function() {
	   /* 목록을 가지고 옴 */
	   xhr.open('GET', 'ajax_list_item.jsp');
	   xhr.send();
	   xhr.onreadystatechange = function() {
		   if (xhr.readyState !== XMLHttpRequest.DONE) return;
		   
		   if (xhr.status === 200) {	// 서버(url)에 문서가 존재함
			   const json = JSON.parse(xhr.response);
		   		for(let data of json.listData) {
			   		// console.log(data.item);
			   		insertItem(data.num, data.item);
		   		}
		   }
		   else {	// 서버(url)에 문서가 존재X 
			   console.error('Error', xhr.status, xhr.statusText);
		   }
	   }
   	}
   
   	const deleteItem = function () {
   		/* 체크박스 클릭시 실행
   			1. 데이터 베이스에서 해당 게시물 삭제
   			2. 해당 태그 삭제*/
   		let item = this;
   		let num = item.getAttribute('name');
   		xhr.open('GET', 'ajax_delete_item.jsp?num=' + num);
   		xhr.send();
   		xhr.onreadystatechange = function() {
   			if (xhr.readyState !== XMLHttpRequest.DONE) return;
   			
   			if(xhr.status === 200) { // 서버(url)에 문서가 존재O 
   				const json = JSON.parse(xhr.response);
   				if(json.delete === 'true') {
   					const pNode = item.parentNode.parentNode;	// item이 input 태그여서 부모 태그인 li 선택
   					pNode.parentNode.removeChild(pNode);	// li 태그 삭제
   					// console.log(item.querySelector('input'));
   					// console.log(item);
   				}
   			}
   			else { // 서버(url)에 문서가 존재X 
   				console.error('Error', xhr.status, xhr.statusText);
   			}
   		}
   	}
   	
   	insertList();
   	
	const trueList = function () {
   		/* 완료 항목 버튼 클릭시 실행
   			1. 데이터 베이스에서 isChecked가 true인 목록 불러오기*/
   		xhr.open('GET', 'ajax_true_item.jsp');
   		xhr.send();
   		xhr.onreadystatechange = function () {
   			if (xhr.readyState !== XMLHttpRequest.DONE) return;
   			
   			if (xhr.status === 200) { // 서버(url)에 문서 존재O 
   				const json = JSON.parse(xhr.response);
   			
   			}
   		}
   	}
   
   
   
      /*이벤트선언*/
      document.querySelector('.insert input[value=등록]').addEventListener('click', function(){
         //등록 버튼 클릭 시
         //1) 데이터베이스에 데이터 등록 2) 화면에 표시
         let item = document.querySelector('.insert input[name=item]');
         
         xhr.open('GET', 'ajax_insert_item.jsp?item=' + item.value);
         xhr.send();
         xhr.onreadystatechange=()=>{
            if(xhr.readyState !==XMLHttpRequest.DONE) return;
            
            if(xhr.status ===200){ //서버 url에 문서가 존재함
               const json =JSON.parse(xhr.response);
               if(json.insert ==='true'){
                  insertItem(json.num, item.value); //화면에 표시
                  item.value=''; //input태그에 입력된 값 삭제
               }
            }
            else{ //서버url 에 문서가 존재하지 않음
               console.error('Error', xhr.status, xhr.statusText);
            }
         }
      });
      
      // 완료 항목 클릭 이벤트
      document.querySelector('.insert input[name=done]').addEventListener('click', function(){
    	 //alert("완료"); // 작동 되는지 확인
    	 
    	 //let value = this.value
    	 //if(value == "false"){value = "true"}
    	 //else{value = "false"}
    	 let item = document.querySelector('.insert input[name=item]');
         /
         xhr.open('GET', 'ajax_insert_item.jsp?item=' + item.value);
        // xhr.open('GET', 'ajax_true_item.jsp?item=' + item.value +'&value =' + value);
         
         xhr.send();
         xhr.onreadystatechange=()=>{
            if(xhr.readyState !==XMLHttpRequest.DONE) return;
            
            if(xhr.status ===200){ //서버 url에 문서가 존재함
               const json =JSON.parse(xhr.response);
               if(json.insert ==='true'){
                  insertItem(json.num, item.value); //화면에 표시
                  item.value=''; //input태그에 입력된 값 삭제
               }
            }
            else{ //서버url 에 문서가 존재하지 않음
               console.error('Error', xhr.status, xhr.statusText);
            }
         }
      });
   });
</script>
</body>
</html>


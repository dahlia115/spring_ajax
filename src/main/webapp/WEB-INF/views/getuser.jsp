<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
<script type="text/javascript">
	function getUsers(){
		$.ajax({
			url:"users", type:"GET", dataType:"json",
			success: function(list){
				//$("#users").text(list)
				let html = ""	//let 지역변수로 지정하겠다
				/*
				html += "<b>아이디</b>" + list[0].name +"님<br>"
				html += "<b>나이</b>" + list[0].age +"살<hr>"
				html += "<b>아이디</b>" + list[1].name +"님<br>"
				html += "<b>나이</b>" + list[1].age +"살<hr>"
				*/
				$.each(list, function(index, item){ //반복문 (저장돼있는 모든데이터)
					html += "<b>아이디</b>" + item.name +"님<br>"
					html += "<b>나이</b>" + item.age +"살<hr>"
					
				})
				//$("#users").text(html)
				//$("#users").html(html)//새로운 내용으로 덮어씌운다
				$("#users").append(html)//기존 데이터에 이어 써준다
			}, error: function(){ alert('문제발생') }
		})
	}
	function userInfo(){
		$.ajax({
			url: "user/"+$("#userId").val(),//url: "user?userId="+$("#userId").val(),
			type : "GET", dataType : "json",
			success: function(list){
				html = ''
				html += "<b>아이디</b>" + list.name +"님<br>"
				html += "<b>나이</b>" + list.age +"살<hr>"
				$("#users").html(html)
			}, error: function(){
				alert('문제 발생')
			}
		
		})
	}
	function userInfo(){
		$.ajax({
			url: "user/"+$("#userId").val(),//url: "user?userId="+$("#userId").val(),
			type : "GET", dataType : "json",
			success: function(list){
				html = ''
				html += "<b>아이디</b>" + list.name +"님<br>"
				html += "<b>나이</b>" + list.age +"살<hr>"
				$("#users").html(html)
			}, error: function(){
				alert('문제 발생')
			}
		
		})
	}
	function membership(){
		/*
		var uId = $("#uId").val;
		var uName = $("#uName").val;
		var uAge = $("#uAge").val;
		var uAddr = $("#uAddr").val;
		var form = {uId:uId, uName:uName, uAge:uAge, uAddr:uAddr}
		*/
		//[{name:uId, value:값1},{name:uNmae, value:값2}...]
		form = {}
		arr =$("#frm").serializeArray()
		for(i=0; i<arr.length;i++){
			form[arr[i].name] = arr[i].value
		}		
		$.ajax({
			url : "membership", type:"POST", dataType:"json",
			data:JSON.stringify(form),
			contentType:"application/json; charset=utf-8",
			seccess: function(list){
				alert('성공적으로 저장')
			}, elert: function(){
				alert('문제발생')
			}
		})
	}
</script>
</head>
<body>
	<h3>회원가입 페이지</h3>
	<form id="frm">
		<input type="text" id="uId" name ="uId" placeholder="id"><br>
		<input type="text" id="uName" name ="uName" placeholder="name"><br>
		<input type="text" id="uAge" name ="uAge" placeholder="age"><br>
		<input type="text" id="uAddr" name ="uAddr" placeholder="addr"><br>
		<input type="button" onclick="membership()" value="가입">
	</form>
	
	<span id="users"></span><hr>
	<button type="button" onclick="getUsers()">사용자보기</button>
	<hr>
	<input type="text" id="userId">
	<button type="button" onclick="userInfo()">개인정보보기</button>
	
</body>
</html>










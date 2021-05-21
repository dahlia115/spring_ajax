<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
<script type="text/javascript">
	function ajaxGet(){
		$.ajax({
			url : "rest", type : "GET", dataType : "json",
			success : function(data){$("#label").text(data.execute) }
		})
	}
	function ajaxPost(){
		$.ajax({
			url : "rest", type : "POST", dataType : "json",
			success : function(data){$("#label").text(data.execute) }
		})
	}
	function ajaxPut(){
		$.ajax({
			url : "rest", type : "PUT", dataType : "json",
			success : function(data){$("#label").text(data.execute) }
		})
	}
	function ajaxDel(){
		$.ajax({
			url : "rest", type : "DELETE", dataType : "json",
			success : function(data){$("#label").text(data.execute) }
		})
	}
</script>
</head>
<body>
	<label id="label">버튼 클릭</label><br>
	<button type="button" onclick="ajaxGet()">get방식</button>
	<button type="button" onclick="ajaxPost()">post방식</button>
	<button type="button" onclick="ajaxPut()">put방식</button>
	<button type="button" onclick="ajaxDel()">del방식</button>

</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
<script type="text/javascript">
	function test(){
		$.ajax({
			url:"ajax",
			type:"GET",
			success: function(){
				alert('연결성공')
			},
			error: function(){
				alert('연결실패')
			}
				
		})
	}
</script>
</head>
<body>
	<h1>1</h1><h1>2</h1><h1>3</h1>
	<h1>4</h1><h1>5</h1><h1>6</h1>
	<h1>7</h1><h1>8</h1><h1>9</h1>
	<hr>
	<button type="button" onclick="test()">클릭</button>
</body>
</html>
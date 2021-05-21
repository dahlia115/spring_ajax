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
                var n = document.getElementById('name').value;
                var a = $("#age").val();
                var form = {age:a, name:n}
                $.ajax({
                        url : "ajax_result01", type : "POST",
                        data : JSON.stringify(form), //보낼 데이터(form을 json타입으로 변경)
                        contentType : "application/json; charset=utf-8", //보낼 데이터 타입 지정
                        dataType : "json", //리턴 type
                        success:function(result){
                                $("#label").text(result.name + " : "+ result.age)
                        }, error: function(){
                                alert('문제발생')
                        }
                })
        }
</script>
</head>
<body>
        <input type="text" id="name" placeholder="input name"><br>
        <input type="text" id="age" placeholder="input age"><br>
        <input type="button" onclick="test()">
        <hr>
        결과 : <label id="label"></label>
</body>
</html>



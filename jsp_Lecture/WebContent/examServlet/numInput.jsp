<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>숫자 더하기</title>
<style type="text/css">
	* {padding: 0; margin: 0;}
	fieldset {text-align:center; width: 300px; padding: 20px 10px; box-sizing: border-box; margin: 30px auto; border: 2px solid blue;}
	input {width :120px; text-align: center;}
	.first {margin-right: 10px; margin-bottom: 10px;}
</style>
</head>
<body>
	<form action="CalculatorSevlet" method="get">
		<fieldset>
			<input class="first" type="text" name="num01" placeholder="숫자 입력"><input type="text" name="num02" placeholder="숫자 입력"><br>
			<input type="submit" value="계산">		
		</fieldset>
	</form>	
</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>이름 전송</title>
<style type="text/css">
	* {padding: 0; maring: 0;}
	div {width: 300px; border: 2px solid blue; margin: 30px auto; padding: 30px 5px; box-sizing: border-box; text-align: center;}
</style>
</head>
<body>
	<div>
		<form action="NameServlet" method="get">
			<input type="text" name="name">
			<input type="submit" value="Get전송">
		</form>
	</div>
	<div>
		<form action="NameServlet" method="post">
			<input type="text" name="name">
			<input type="submit" value="Post전송">
		</form>
	</div>
</body>
</html>
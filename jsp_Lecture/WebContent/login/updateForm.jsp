<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>회원가입</title>
</head>
<style>
	h2 {text-align: center;}
	form {text-align: right;}
	div {width: 270px; box-sizing: border-box;  border: 2px solid black; margin: 20px auto; padding-right:10px; padding-bottom:10px;}
	ul {list-style-type: none;}
	.center {text-align: center;}
</style>
<body>
	<div>
		<h2>회원가입</h2>
		<form method="post" action="BmemberUdate">
		<input type="hidden" name="id" value=<%= session.getAttribute("uid") %>>
		<p>패스워드: <input type="text" name="pw" value=<%= session.getAttribute("upw") %>></p>
		<p>이름: <input type="text" name="name" value=<%= session.getAttribute("uname") %>></p>
		<p class="center"><input type="submit" value="보내기"></p>
	</form>
	</div>
</body>
</html>
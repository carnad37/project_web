<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<style type="text/css">
	* {margin: 0; padding: 0;}
	div {padding: 30px 0; width: 250px; box-sizing: border-box;  border: 2px solid black; margin: 20px auto;text-align: center;}
	p {margin-top: 20px;}
</style>
</head>
<body>
  <div>
  	<form action="StudentSubjectSearch" method="post">
	    <label>학과 : <input type="text" name="subject"></label>
	    <p><input type="submit" value="보내기"></p>
  	</form>
  </div>
</body>
</html>

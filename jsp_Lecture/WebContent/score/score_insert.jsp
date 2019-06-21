<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>학생 점수 등록</title>
<style type="text/css">
	div {width: 240px; box-sizing: border-box;  border: 2px solid black; margin: 20px auto;}
	input {width: 100px; text-align: center;}
  	ul {list-style: none; padding: 0; text-align: right;}
  	li {font-size: 16px; margin-bottom: 10px; margin-right: 25px;}
  	p, h3 {text-align: center;}
</style>
</head>
<body>
  <div>
	<form action="Score_Insert" method="post">
		<h3>점수 등록</h3>
  		<ul>
  		  <li><label>이름 : <input type="text" name="name"></label></li>
          <li><label>국어점수 : <input type="text" name="lan"></label></li>
          <li><label>영어점수 : <input type="text" name="eng"></label></li>
          <li><label>수학점수 : <input type="text" name="mat"></label></li>
          <li><label>과학점수 : <input type="text" name="sci"></label></li>
          <li><label>사회점수 : <input type="text" name="com"></label></li>
          <li><label>음악점수 : <input type="text" name="mus"></label></li>
          <li><label>체육점수 : <input type="text" name="phy"></label></li>
   		</ul>
  	  <p><input type="submit" value="보내기"></p>
	</form>
  </div>
</body>
</html>
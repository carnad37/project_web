<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>학생 평균 점수 출력</title>
</head>
<style type="text/css">
	div {width: 240px; box-sizing: border-box;  border: 2px solid black; margin: 20px auto;}
	input {width: 100px; text-align: center;}
  	ul {list-style: none;}
  	li {font-size: 16px; margin-bottom: 10px;}
  	p, h3 {text-align: center;}
</style>
<body>
	  <div>
  	<form action="Score_Search_Avg" method="post">
  		<h3>학생 평균 점수</h3>
  		<ul>
  		  <li><label>이름 : <input type="text" name="name"></label></li>
   		</ul>
	    <p><input type="submit" value="보내기"></p>
  	</form>
  </div>
</body>
</html>
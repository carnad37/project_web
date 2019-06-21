<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<style type="text/css">
	* {margin: 0; padding: 0;}
	div {padding: 30px 0; width: 300px; box-sizing: border-box;  border: 2px solid black; margin: 20px auto;text-align: center;}
	p {margin-top: 20px; text-align: center}
	li {text-align: right; margin-right: 25px; margin-bottom: 10px;}
	li:nth-last-child(1) {margin-bottom: 0px;}
	ul {list-style-type: none;}
	.first, .second, .third {display: inline-block;  text-align: center;}
	.first {width: 40px;}
	.second, .third {width: 50px;}
    .first, .second {margin-right: 10px;}
</style>
</head>
<body>
  <div>
  	<form action="StudentInsert" method="post">
  		<ul>
  		  <li><label>이름 : <input type="text" name="name"></label></li>
          <li><label>학번 : <input type="text" name="student_id"></label></li>
          <li><label>전화번호 : <input class="first" type="text" name="first" maxlength="3"><input class="second" type="text" name="second" maxlength="4"><input class="third" type="text" name="third" maxlength="4"></label></li>
          <li><label>학과 : <input type="text" name="subject"></label></li>
  		</ul>
	    <p><input type="submit" value="보내기"></p>
  	</form>
  </div>
</body>
</html>

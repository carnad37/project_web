<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	session.invalidate();
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<style type="text/css">
	div {width: 200px; box-sizing: border-box;  border: 2px solid black; margin: 20px auto;}
  	ul {list-style: none;}
  	a {text-decoration: none; color:black;}
  	a:hover {color:blue; font-weight: bold;}
  	li {font-size: 16px; margin-bottom: 10px;}
</style>
</head>
<body>
	<div>
	  <ul>
	    <li><a href="student_insert.jsp">1.학생 등록</a></li>
	    <li><a href="student_search_name.jsp">2.이름으로 검색</a></li>
	    <li><a href="student_search_ID.jsp">3.학번으로 검색</a></li>
	    <li><a href="student_search_subject.jsp">4.학과로 검색</a></li>
	  </ul>
	</div>
</body>
</html>

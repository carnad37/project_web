<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
		int num01 = (int)session.getAttribute("num01");
		int num02 = (int)session.getAttribute("num02");
		int add = (int)session.getAttribute("add");
		int sub = (int)session.getAttribute("sub");
		int mul = (int)session.getAttribute("mul");
		double div = (double)session.getAttribute("div");
		session.invalidate();
	%>
	<p><%= num01 %> + <%= num02 %> = <%= add %></p> <br>
	<p><%= num01 %> - <%= num02 %> = <%= sub %></p> <br>
	<p><%= num01 %> * <%= num02 %> = <%= mul %></p> <br>
	<p><%= num01 %> / <%= num02 %> = <%= div %></p> <br>
	
	<a href="numInput.jsp">다시 계산하기</a>
</body>
</html>
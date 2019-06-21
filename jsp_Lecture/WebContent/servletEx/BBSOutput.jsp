<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>출력</title>
</head>
<body>
	<%
		request.setCharacterEncoding("euc-kr");
		String name = (String)session.getAttribute("name");
		String title = (String)session.getAttribute("title");
		String content = (String)session.getAttribute("content");
	%>
	<ul>
		<li>name : <%= name %></li>
		<li>title : <%= title %></li>
		<li>content : <%= content %></li>		
	</ul>
</body>
</html>
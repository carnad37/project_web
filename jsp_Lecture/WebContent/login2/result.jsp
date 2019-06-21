<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<style type="text/css">
	div {text-align: center; width: 300px; box-sizing: border-box;border: 2px solid black; margin: 20px auto;}
</style>
</head>
<body>
	<%
		String result = (String)session.getAttribute("result");
		session.removeAttribute("result");
	%>
	<div>
		<p><%= result %></p>
		<p><a href="Main.jsp">메인으로 돌아가기</a></p>
	</div>
</body>
</html>
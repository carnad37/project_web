<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
<style>
	div {width: 200px; box-sizing: border-box;  border: 2px solid black; margin: 20px auto;}
	a {text-decoration: none; color: black;}
	a:hover {color:blue; font-weight: bold;}
	.menu {margin-left: 40px;}
	.welcom {text-align: center; font-size: 18px;}
	span {font-weight: bold;}
</style>
</head>
<body>
	<div>	
		<%
		String id = (String)session.getAttribute("uid");
		if (id == null) {
		%>
			<p class="menu"><a href="loginForm.html">1.�α���</a></p>
			<p class="menu"><a href="insertForm.html">2.ȸ�� ���</a></p>
			<p class="menu"><a href="searchFrom.html">3.ȸ�� �˻�</a></p>		
		<%	
		} else {
		%>
			<p class="welcom">ȯ���մϴ�, <span><%= id %></span>��</p>
			<p class="menu"><a href="searchFrom.html">1.ȸ�� �˻�</a></p>
			<p class="menu"><a href="updateForm.jsp">2.ȸ�� ���� ����</a></p>
			<p class="menu"><a href="logout.jsp">3.�α׾ƿ�</a></p>		
		<%
		}
		%>
	</div>
</body>
</html>
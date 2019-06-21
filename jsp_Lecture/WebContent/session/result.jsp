<%@page pageEncoding="euc-kr" contentType="text/html; charset=euc-kr" %>
<%
	String nick = request.getParameter("nickname");
	session.setAttribute("nickname",nick);	
%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=MS949"/>
<title></title>
</head>
<body>
uid : <%= session.getAttribute("uid") %>
upw : <%= session.getAttribute("upw") %>
nickname : <%= session.getAttribute("nickname") %>
<% 
	session.invalidate();
%>
<br><a href="main.jsp">   메인화면으로 이동</a> 
</body>
</html>

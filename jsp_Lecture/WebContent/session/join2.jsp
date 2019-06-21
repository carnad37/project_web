<%@page pageEncoding="euc-kr" contentType="text/html; charset=euc-kr" %>
<%
	String juid = request.getParameter("uid");
	session.setAttribute("uid",juid);	
%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=MS949"/>
<title></title>
</head>
<body>
<form action = "join3.jsp" method="post">
		pw : <input type ="text" name="upw">
		<input type ="submit" value="2단계 완료">
	</form>
</body>
</html>

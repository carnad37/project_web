<%@page pageEncoding="euc-kr" contentType="text/html; charset=euc-kr" %>
<%
	String jupw = request.getParameter("upw");
	session.setAttribute("upw",jupw);	
%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=MS949"/>
<title></title>
</head>
<body>
<form action = "result.jsp" method="post">
		nick : <input type ="text" name="nickname">
		<input type ="submit" value="최종완료">
	</form>
</body>
</html>

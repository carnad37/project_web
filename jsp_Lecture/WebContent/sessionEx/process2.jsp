<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%
	request.setCharacterEncoding("EUC-KR");
	String juid = request.getParameter("uid");	
	session.setAttribute("uid", juid);	//키값을 uid로, 밸류를 해당값으로 세션에 저장.
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<body>
		<form action="result.jsp" method="post">
		<label id="pw">pw : <input type="password" name="upw" id="pw"> </label>
		<input type="submit" value="비밀번호 입력">
	</form>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%
	request.setCharacterEncoding("EUC-KR");
	String juid = request.getParameter("uid");	
	session.setAttribute("uid", juid);	//Ű���� uid��, ����� �ش簪���� ���ǿ� ����.
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
		<input type="submit" value="��й�ȣ �Է�">
	</form>
</body>
</html>
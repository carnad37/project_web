<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<body>
<%
	String appPath = application.getContextPath();
	String absolutePath = application.getRealPath("login.jsp");
	System.out.println(absolutePath);
	//콘솔창에 출력됨(/jsp_lecture라고)
%>
</body>
</html>
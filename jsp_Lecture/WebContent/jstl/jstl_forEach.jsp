<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix= "c" uri= "http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<c:forEach begin="1" end="5">
		<h5>안녕하세요, 여러분!</h5>
	</c:forEach>
	<c:forEach var="cnt" begin="1" end="7" step="2">
		<font size="${cnt}">야호~</font><br>
	</c:forEach>
	
</body>
</html>
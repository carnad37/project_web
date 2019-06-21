<%@page import="com.jstlEx.MemberDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	-----object-----<br>
		${mdto.name}<br><br>
	-----array-----<br>
	<c:forEach var="mdtoArrVal" items="${mdtosArr}">
		${mdtoArrVal}<br>
	</c:forEach><br><br>
	-----for each List-----<br>
	<c:forEach var="mdtosVal" items="${mdtosList}">
		${mdtosVal}<br>
	</c:forEach><br><br>
	-----for each String Map-----<br>
	<c:forEach var="mdtosString" items="${mdtosStringMap}">
		id : ${mdtosString.key}, pw : ${mdtosString.value}<br>	
	</c:forEach><br><br>
	-----for each Object Map------<br>
	<c:forEach var="mdtosObj" items="${mdtosObjectMap}">
		id : ${mdtosObj.key}, pw : ${mdtosObj.value}<br>
	</c:forEach><br><br>	
</body>
</html>
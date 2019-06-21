<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<c:set var="num1" value="7"/>
	<c:set var="num2" value="9"/>
	<c:set var="num3" value="${i}"/>
	<c:set var="num4" value="${j}"/>
	<c:set var="result" value="${num1*num2}"/>
	<c:set var="resultEl" value="${num3*num4}"/>
	${num1}과 ${num2}의 곱은? ${result}
	<br><br>
	el로 변수값 저장<br>
	${num3}와 ${num4}의 곱은? ${resultEl}<br>
	<c:if test="${num3<num4}">
		num2이 더 큽니다.<br>
	</c:if>
	<c:choose>
		<c:when test="${num3 == 10}">
			num3은 10<br>
		</c:when>
		<c:when test="${num3 == 20}">
			num3은 20<br>
		</c:when>
		<c:otherwise>
			num3는 10도 20도 아닙니다.<br>
		</c:otherwise>
	</c:choose>
	<br><br>
	<c:forEach var="dish" items="${MENU}">
		${dish}<br>	
	</c:forEach>
	
</body>
</html>
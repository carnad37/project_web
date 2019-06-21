<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	첫번째수: <fmt:formatNumber value="12345000" groupingUsed="true"/><br>
	두번째수: <fmt:formatNumber value="3.14558" pattern="#.##"/><br>
	세번째수: <fmt:formatNumber value="3.14558" pattern="#.00"/><br><br>
	금액: <fmt:formatNumber value="1000000" type="currency" currencySymbol="\\"/><br>
	퍼센트: <fmt:formatNumber value="0.99" type="percent"/><br><br>	
	<c:set var="num" value="10.5555"></c:set>
	반올림 : <fmt:formatNumber value="${num}" pattern="#.00" /><br>
	소숫점없앰 : <fmt:parseNumber var="integerVal" value="${num}" integerOnly="true"/>${integerVal}
</body>
</html>
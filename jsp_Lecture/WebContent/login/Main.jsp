<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
<style>
	div {width: 200px; box-sizing: border-box;  border: 2px solid black; margin: 20px auto;}
	a {text-decoration: none; color: black;}
	a:hover {color:blue; font-weight: bold;}
	.menu {margin-left: 40px;}
	.welcom {text-align: center; font-size: 18px;}
	span {font-weight: bold;}
</style>
</head>
<body>
	<div>	
		<%
		String id = (String)session.getAttribute("uid");
		if (id == null) {
		%>
			<p class="menu"><a href="loginForm.html">1.로그인</a></p>
			<p class="menu"><a href="insertForm.html">2.회원 등록</a></p>
			<p class="menu"><a href="searchFrom.html">3.회원 검색</a></p>		
		<%	
		} else {
		%>
			<p class="welcom">환영합니다, <span><%= id %></span>님</p>
			<p class="menu"><a href="searchFrom.html">1.회원 검색</a></p>
			<p class="menu"><a href="updateForm.jsp">2.회원 정보 수정</a></p>
			<p class="menu"><a href="logout.jsp">3.로그아웃</a></p>		
		<%
		}
		%>
	</div>
</body>
</html>
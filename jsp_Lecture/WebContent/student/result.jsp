<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>Insert title here</title>
	<style type="text/css">
		* {margin: 0; padding: 0;}
		div {padding: 30px 0; width: 250px; box-sizing: border-box;  border: 2px solid black; margin: 20px auto;text-align: center;}
		p {margin-top: 20px;}
	  	a {text-decoration: none; color:black;}
 	 	a:hover {color:blue; font-weight: bold;}
 	 	ul {list-style-type: none;}
 	 	
	</style>
</head>
<body>
	<div>
		<ul>
			<c:choose>
				<c:when test="${result eq 'ID'}">
					<c:forEach var="student" items="${stuList}">
						<li><strong>이름</strong> : ${student.name}</li>
						<li><strong>전화번호</strong> : ${student.phone}</li>
						<br>
					</c:forEach>
				</c:when>
				<c:when test="${result eq 'name'}">
					<c:forEach var="student" items="${stuList}">
						<li><strong>학번</strong> : ${student.student_id}</li>
						<li><strong>전화번호</strong> : ${student.phone}</li>
						<li><strong>학과</strong> : ${student.subject}</li>
						<br>
					</c:forEach>
				</c:when>
				<c:when test="${result eq 'subject'}">
					<c:forEach var="student" items="${stuList}">
						<li><strong>이름</strong> : ${student.name}</li>
						<li><strong>학번</strong> : ${student.student_id}</li>
						<br>
					</c:forEach>
				</c:when>
				<c:when test="${result eq 'insert'}">
					<c:forEach var="student" items="${stuList}">
						<li><strong>이름</strong> : ${student.name}</li>
						<li><strong>학번</strong> : ${student.student_id}</li>
						<li><strong>전화번호</strong> : ${student.phone}</li>
						<li><strong>학과</strong> : ${student.subject}</li>
						<br>
					</c:forEach>
				</c:when>
				<c:otherwise>
					<li><strong>${result}</strong></li>
				</c:otherwise>
			</c:choose>
		</ul>
		<p><a href="main.jsp">메인메뉴로 돌아가기</a></p>
	</div>
</body>
</html>

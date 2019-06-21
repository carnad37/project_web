<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>게시판 리스트</title>
</head>
<body>
		<table width="500" cellpadding="0" cellspacing="0" border="1">
		<tr>
			<td>번호</td>
			<td>이름</td>
			<td>제목</td>
			<td>날짜</td>
			<td>히트</td>
		</tr>
		<c:forEach items="${bdto}" var="dto">
		<tr>
			<td>${dto.bId}</td>
			<td>${dto.bName}</td>
			<td>
				<c:forEach begin="1" end="${dto.bIndent}"> - </c:forEach>
				<a href="content_view.do?bId=${dto.bId}">${dto.bTitle}</a></td>
			<td><fmt:formatDate value="${dto.bDate}" pattern="yyyy-MM-dd"/></td>
			<td>${dto.bHit}</td>
		</tr>
		</c:forEach>
		<tr>
			<td colspan="5"> <a href="write_view.do">글작성</a> </td>
		</tr>
	</table>
	<form method="post" action="start.do">
		<input type="hidden" value="data">
		<input type="submit" value="시작">
	</form>
		<form method="post" action="commit.do">
		<input type="hidden" value="data">
		<input type="submit" value="커밋">
	</form>
		<form method="post" action="rollback.do">
		<input type="hidden" value="data">
		<input type="submit" value="롤백">
	</form>
	<form method="post" action="qCommit.do">
		<input type="hidden" value="data">
		<input type="submit" value="쿼리 커밋">
	</form>
		<form method="post" action="qRollback.do">
		<input type="hidden" value="data">
		<input type="submit" value="쿼리 롤백">
	</form>
	<form method="post" action="test.do">
		<input type="hidden" value="data">
		<input type="submit" value="테스트">
	</form>
</body>
</html>
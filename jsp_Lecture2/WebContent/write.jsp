<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<style type="text/css">
	table {box-sizing: border-box;}
 textarea {width: 99%;}
 a {text-decoration: none; margin-left: 10px;}
 .title {width: 99%;}
</style>
</head>
<body>
	<form action="write.do" method="post" id="write">
		<table width="500" cellpadding="0" cellspacing="0" border="1">
			<tr>
				<td>이름</td>
				<td><input type="text" name="name"></td>
			</tr>
			<tr>
				<td>제목</td>
				<td><input class="title" type="text" name="title"></td>
			</tr>
			<tr>
				<td>내용</td>
				<td><textarea rows="20" form="write" name="content"></textarea></td>
			</tr>
			<tr>
				<td colspan="2"><input type="submit" value="입력"><a href="list.do">목록보기</a></td>
			</tr>
		</table>
	</form>
</body>
</html>
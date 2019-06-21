<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ page import = "java.sql.*" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<body>
<%
//1. 드라이버로드
//2. 커넥션 연결
//3. paredStatmemt 객체 생성
//---  검색 - password
//4. SQL 만들기  -SELECT pw FROM bmember WHERE id = '?'
//5. set 메소드로  SQL ? 값  채우기
//6. executeQuery
//7. 데이터 받으면 ResultSet 에서 꺼내오기
//8 입력된 패스워드랑  디비에서 가져온 패스워드 비교
//9 SQL 만들기 - update bememer set name='?' where id='?'
//10. 9번의 ? 채우기 set method
//11. executeUpdate로 전송
//12. SQL 만들기 - id name 출력을 위한
//13. set 메소드로  SQL ? 값  채우기
//14. executeQuery-SELECT id, name FROM bmember WHERE id = '?'
//15. ResultSet 객체의 id, name 출력
%>
</body>
</html>
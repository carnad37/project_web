<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ page import = "java.sql.*" %>
<%
	request.setCharacterEncoding("utf-8");
	String phone = request.getParameter("top") + "-" +  request.getParameter("middle") + "-" +  request.getParameter("bottom");
	
	String driver = "com.mysql.jdbc.Driver";
	String dbName = "jsplecture_db";
	String dbURL = "jdbc:mysql://localhost:3306/" + dbName;
	String name = null;
	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet result = null;
	try {
		Class.forName(driver);
		conn = DriverManager.getConnection(dbURL, "root", "user1234");
		String SQL = "select name from address_db where phone = ?";
		pstmt = conn.prepareStatement(SQL);
		pstmt.setString(1, phone);
		result = pstmt.executeQuery();
		if(!result.isBeforeFirst()) {
			out.print("등록되지 않은 전화번호입니다.");
		} else {
			while (result.next()) {
				name = result.getString("name");
				out.println("이름 : " + name + ", 전화번호 : " + phone);
			}
		}
	} catch (ClassNotFoundException e) {
		out.println("클래스를 찾을수가 없습니다.");
	} catch (SQLException e) {
		out.println("서버와의 연결에 오류가 발생했습니다.");
		out.println(e);
		e.printStackTrace();
	} finally {
		if (pstmt != null) try {pstmt.close();} catch (SQLException e) {}
		if (conn != null) try {conn.close();} catch (SQLException e) {}
	}
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>전화번호로 이름 찾기 결과</title>
</head>
<body>
	<h3><a href="Addressbook_searchPhoneToName.html">다른 전화번호로 이름 검색하기</a></h3>
	<h3><a href="Addressbook_menu.html">메인메뉴로 돌아가기</a></h3>
</body>
</html>
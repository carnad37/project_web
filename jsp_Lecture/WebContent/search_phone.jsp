<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ page import = "java.sql.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>전화번호-주소 검색 결과</title>
</head>
<body>
<%
	request.setCharacterEncoding("utf-8");
	String phone = request.getParameter("top") + "-" +  request.getParameter("middle") + "-" +  request.getParameter("bottom");

	String driver = "com.mysql.jdbc.Driver";
	String dbName = "jsplecture_db";
	String dbURL = "jdbc:mysql://localhost:3306/" + dbName;
	int post_num = 0;
	String city_do = null;
	String city_si = null;
	String lot_num = null;
	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet result = null;
	try {
		Class.forName(driver);
		conn = DriverManager.getConnection(dbURL, "root", "user1234");
		String SQL = "select post_num, city_do, city_si, lot_num from address_db where phone = ?";
		pstmt = conn.prepareStatement(SQL);
		pstmt.setString(1, phone);
		result = pstmt.executeQuery();
		if(!result.isBeforeFirst()) {
			out.print("등록되지 않은 전화번호입니다.");
		} else {
			while (result.next()) {
				post_num = result.getInt("post_num");
				city_do = result.getString("city_do");
				city_si = result.getString("city_si");
				lot_num = result.getString("lot_num");
%>
		<h4>우편번호: <%= post_num %>, 도: <%= city_do %>, 시: <%= city_si %>, 지번: <%= lot_num %></h4>
		<br>
<%
			}
		}
	} catch (ClassNotFoundException e) {
		out.println("클래스를 찾을수가 없습니다.");
	} catch (SQLException e) {
		out.println("서버와의 연결에 오류가 발생했습니다.");
		out.println(e);
	} finally {
		if (pstmt != null) try {pstmt.close();} catch (SQLException e) {}
		if (conn != null) try {conn.close();} catch (SQLException e) {}
	}
%>
	<h3><a href="Addressbook_searchPhone.html">다른 전화번호로 주소 검색하기</a></h3>
	<h3><a href="Addressbook_menu.html">메인메뉴로 돌아가기</a></h3>
</body>
</html>
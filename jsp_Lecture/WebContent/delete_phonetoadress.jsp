<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ page import = "java.sql.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>주소 삭제</title>
</head>
<body>
<%
	request.setCharacterEncoding("utf-8");
	String phone = request.getParameter("top") + "-" +  request.getParameter("middle") + "-" +  request.getParameter("bottom");
	
	String driver = "com.mysql.jdbc.Driver";
	String dbName = "jsplecture_db";
	String dbURL = "jdbc:mysql://localhost:3306/" + dbName;
	String name = null;
	Connection conn = null;
	PreparedStatement pstmt = null;
	
	try {
		Class.forName(driver);
		conn = DriverManager.getConnection(dbURL, "root", "user1234");
		String SQL = "delete from address_db where phone = ?";
		pstmt = conn.prepareStatement(SQL);
		pstmt.setString(1, phone);
		int retval = pstmt.executeUpdate();
		if (retval != 1) {
			out.println("삭제에 실패하였습니다. 정확한 전화번호를 입력해주세요.");
			out.println("입력된 전화번호 : " + phone);
		} else {
			out.println("삭제에 성공하였습니다.");
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
	<h3><a href="Addressbook_delete_phone.html">다른 전화번호로 주소 삭제하기</a></h3>
	<h3><a href="Addressbook_menu.html">메인메뉴로 돌아가기</a></h3>
</body>
</html>
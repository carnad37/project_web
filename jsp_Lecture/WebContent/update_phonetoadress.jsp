<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ page import = "java.sql.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
</head>
<body>
	<%
		request.setCharacterEncoding("utf-8");
		String phone = request.getParameter("phone");
		int post_num = Integer.parseInt(request.getParameter("post_num"));
		String name = request.getParameter("name");
		String city_do = request.getParameter("city_do");
		String city_si = request.getParameter("city_si");
		String lot_num = request.getParameter("lot_num");
		Connection conn = null;
		PreparedStatement pstmt = null;
	
		String DriverName = "com.mysql.jdbc.Driver";
		String dbName = "jsplecture_db";
		String dbURL = "jdbc:mysql://localhost:3306/" + dbName;
		try {
			Class.forName(DriverName);
			conn = DriverManager.getConnection(dbURL, "root", "user1234");
			String SQL = "update address_db set name = ?, post_num = ?, city_do = ?, city_si = ?, lot_num = ? where phone = ?";
			pstmt = conn.prepareStatement(SQL);
			pstmt.setString(1, name);
			pstmt.setInt(2, post_num);
			pstmt.setString(3, city_do);
			pstmt.setString(4, city_si);
			pstmt.setString(5, lot_num);
			pstmt.setString(6, phone);
			int retval = pstmt.executeUpdate();
			if (retval != 1) {
				out.println("데이터 수정에 실패했습니다...");
			} else {
				out.println("데이터 수정에 성공했습니다.");
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
	<h3><a href="Addressbook_update_phone.html">다른 전화번호로 수정대상 검색하기</a></h3>
	<h3><a href="Addressbook_menu.html">메인메뉴로 돌아가기</a></h3>
</body>
</html>
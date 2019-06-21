<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ page import = "java.sql.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>주소 정보 수정하기</title>
</head>
<body>
<%
	request.setCharacterEncoding("utf-8");
	String phone = request.getParameter("top") + "-" +  request.getParameter("middle") + "-" +  request.getParameter("bottom");
	String name = request.getParameter("name");
	String post_num = request.getParameter("post_num");
	String city_do = request.getParameter("city_do");
	String city_si = request.getParameter("city_si");
	String lot_num = request.getParameter("lot_num");
	
	String[] targetArray = {name, post_num, city_do, city_si, lot_num};
	String[] targetName = {"name", "post_num", "city_do", "city_si", "lot_num"};
	
	int targetNum = 0;
	boolean firstFlag = false;
	
	String sql = "update address_db set ";
	for (int i = 0; i < targetArray.length; i++) {
		if (firstFlag == true) {
			if (!targetArray[i].equals("")) {
				sql += ", " + targetName[i] + " = ?";
				targetNum++;
			}
		} else {
			if (!targetArray[i].equals("")) {
				firstFlag = true;
				sql += targetName[i] + " = ?";
				targetNum++;
			}
		}
	}
	sql += " where phone = ?";

	if (firstFlag == false) {
		out.println("최소 한개이상의 수정값을 입력해주세요.");
	} else {
		String driver = "com.mysql.jdbc.Driver";
		String dbName = "jsplecture_db";
		String dbURL = "jdbc:mysql://localhost:3306/" + dbName;
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(dbURL, "root", "user1234");
			pstmt = conn.prepareStatement(sql);
			int i = 0;
			boolean error = false;
			for (i = 0; i < 5; i++) {
				int num = 0;
				for (String target : targetArray) {
					if (!target.equals("")) {
						num++;
						pstmt.setString(num, target);
					}
				}
				pstmt.setString(num + 1, phone);
				int retval = pstmt.executeUpdate();
				if (retval != 1) {
					out.print("등록되지 않은 전화번호 입니다.");
					error = true;
					break;
				}
				pstmt.clearParameters();
			}
			
			if (error == false) {
				out.println("전송을 완료하였습니다.");
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
	}	
%>
	<h3><a href="Addressbook_update_phone.html">다른 전화번호로 주소 수정하기</a></h3>
	<h3><a href="Addressbook_menu.html">메인메뉴로 돌아가기</a></h3>
</body>
</html>
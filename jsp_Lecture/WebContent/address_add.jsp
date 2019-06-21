<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ page import = "java.sql.*" %>
<%
	request.setCharacterEncoding("utf-8");
	String phone = request.getParameter("top") + "-" +  request.getParameter("middle") + "-" +  request.getParameter("bottom");
	String name = request.getParameter("name");
	int post_num = Integer.parseInt(request.getParameter("post_num"));
	String city_do = request.getParameter("city_do");
	String city_si = request.getParameter("city_si");
	String lot_num = request.getParameter("lot_num");
	
	String driver = "com.mysql.jdbc.Driver";
	String dbName = "jsplecture_db";
	String dbURL = "jdbc:mysql://localhost:3306/" + dbName;
	Connection conn = null;
	PreparedStatement pstmt = null;
	try {
		Class.forName(driver);
		conn = DriverManager.getConnection(dbURL, "root", "user1234");
		String SQL = "insert into address_db (phone, name, post_num, city_do, city_si, lot_num) values (?, ?, ?, ?, ?, ?)";
		pstmt = conn.prepareStatement(SQL);
		pstmt.setString(1, phone);
		pstmt.setString(2, name);
		pstmt.setInt(3, post_num);
		pstmt.setString(4, city_do);
		pstmt.setString(5, city_si);
		pstmt.setString(6, lot_num);
		int retval = pstmt.executeUpdate();
		if (retval != 1) {
			out.println("�ּ� ��Ͽ� �����Ͽ����ϴ�...");
		} else {
			out.println("�ּ� ��Ͽ� �����Ͽ����ϴ�.");
		}
	} catch (ClassNotFoundException e) {
		out.println("Ŭ������ ã������ �����ϴ�.");
	} catch (SQLException e) {
		out.println("�������� ���ῡ ������ �߻��߽��ϴ�.");
		out.println(e);
	} finally {
		if (pstmt != null) try {pstmt.close();} catch (SQLException e) {}
		if (conn != null) try {conn.close();} catch (SQLException e) {}
	}
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<style>
    a {text-decoration: none; color: black;}
    a:hover {color: blue;}
</style>
<body>
	<br>
	<h3><a href="Addressbook_addAdress.html">�ٸ� �ּ� ����ϱ�</a></h3>
	<br>
	<h3><a href="Addressbook_menu.html">���θ޴��� ���ư���</a></h3>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ page import = "java.sql.*" %>
<%
	request.setCharacterEncoding("euc-kr");
	String id = request.getParameter("id");
	Connection conn = null;
	PreparedStatement pstmt = null;
	String dbName = "jsplecture_db";
	String dbURL = "jdbc:mysql://localhost:3306/" + dbName;
	ResultSet result = null;
	try {
		Class.forName("com.mysql.jdbc.Driver");
		conn = DriverManager.getConnection(dbURL, "root", "user1234");
		String SQL = "select name from bmember where id = ?";
		pstmt = conn.prepareStatement(SQL);
		pstmt.setString(1, id);
		result = pstmt.executeQuery();
		boolean check = result.isBeforeFirst();
		if(check == false) {
			out.println("아이디를 잘못 입력하셨습니다.");
		} else {
			while (result.next()) {
				String name = result.getString("name");
				out.println("검색된 이름은 " + name + "입니다.");
			}
		}
	} catch(ClassNotFoundException e) {
		out.println("mysql 드라이브를 찾을 수가 없습니다.");
	} catch(SQLException e) {
		out.println(e);
		out.println("SQLException이 발생하였습니다.");
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
<body>

</body>
</html>
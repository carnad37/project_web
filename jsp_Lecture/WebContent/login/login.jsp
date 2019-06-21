<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ page import = "java.sql.*" %>
	<%	
	request.setCharacterEncoding("euc-kr");
	String id = request.getParameter("id");
	String pw = request.getParameter("pw");
	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet result = null;
	
	boolean login = false;
	try {
		Class.forName("com.mysql.jdbc.Driver");
		String dbName = "jsplecture_db?useSSL=false";
		String dbURL = "jdbc:mysql://localhost:3306/" + dbName;
		String SQL = "select pw from bmember where id = ?";
		conn = DriverManager.getConnection(dbURL, "root", "user1234");
		pstmt = conn.prepareStatement(SQL);
		pstmt.setString(1, id);
		result = pstmt.executeQuery();
		boolean dataCheck = result.isBeforeFirst();
		boolean loginCheck = false;
		if (dataCheck == false) {
			out.println("��ϵ��� ���� ���̵� �Դϴ�.");
		} else {
			while (result.next()) {
				String password = result.getString("pw");
				if(password.equals(pw)) {
					loginCheck = true;
					break;
				}
			}
			if (loginCheck == true) {
				out.println("�α��ο� �����Ͽ����ϴ�.");
				session.setAttribute("uid",	id);
				session.setAttribute("upw", pw);
				login = true;
			} else {
				out.println("��й�ȣ�� �߸��Է��ϼ̽��ϴ�.");
			}
		}
	} catch (SQLException e) {
		out.println("SQLException�� �߻��Ͽ����ϴ�.");
	} catch (ClassNotFoundException e){
		out.println("mysql ����̺긦 ã�� ���� �����ϴ�.");
	} finally {
		if (pstmt != null) try{pstmt.close();}catch(SQLException e){}
		if (conn != null) try{conn.close();}catch(SQLException e){}

	}
	%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>�α���</title>
</head>
<body>
	<%
		if (login == true) {
			response.sendRedirect("login_page.jsp");
		}
	%>
</body>
</html>
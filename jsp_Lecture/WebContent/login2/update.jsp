<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ page import = "java.sql.*" %>
	<%
	request.setCharacterEncoding("euc-kr");
	String id = request.getParameter("id");
	String pw = request.getParameter("pw");
	String npw = request.getParameter("npw");
	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet result = null;
	boolean loginCheck = false;
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
			if (loginCheck == false) {
				out.println("��й�ȣ�� �߸��Է��ϼ̽��ϴ�.");
			} else {				
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
<title>��й�ȣ ���� ���</title>
<style type="text/css">
	.pre-pw {color:red;}
	.post-pw {color:blue;}
</style>
</head>
<body>
	<%
	if(loginCheck == true) {
		try {
			String dbName = "jsplecture_db?useSSL=false";
			String dbURL = "jdbc:mysql://localhost:3306/" + dbName;
			String SQL = "update bmember set pw = ? where id = ?";
			conn = DriverManager.getConnection(dbURL, "root", "user1234");
			pstmt = conn.prepareStatement(SQL);
			pstmt.setString(1, npw);
			pstmt.setString(2, id);
			int retval = pstmt.executeUpdate();
			if (retval != 1) {
				out.println("������ ������Ʈ �������� ������ �߻��߽��ϴ�.");
			} else {
				out.println("��й�ȣ ������ �Ϸ��߽��ϴ�.");
	%>
	<br>
	<h3>����<span class="pre-pw">��</span> ��й�ȣ: <span class="pre-pw"><%= pw %></span></h3>
	<h3>����<span class="post-pw">��</span> ��й�ȣ: <span class="post-pw"><%= npw %></span></h3>
	<%
			}
		} catch (SQLException e) {
			out.println("SQLException�� �߻��Ͽ����ϴ�.");
		} finally {
			if (pstmt != null) try{pstmt.close();}catch(SQLException e){}
			if (conn != null) try{conn.close();}catch(SQLException e){}
		} 
	}
	%>
</body>
</html>
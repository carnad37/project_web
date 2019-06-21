<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ page import = "java.sql.*" %>
<%
	request.setCharacterEncoding("euc-kr");
	String id = request.getParameter("id");
	String pw = request.getParameter("pw");
	String name = request.getParameter("name");
	String pwd = null;
	Connection conn = null;
//	Statement stmt = null;
	PreparedStatement pstmt = null;
	int retval = 0;
	try {
		Class.forName("com.mysql.jdbc.Driver");
		String dbName = "jsplecture_db?useSSL=false";
		String dbURL = "jdbc:mysql://localhost:3306/" + dbName;
		String sql = "insert into bmember values (?, ?, ?)";
		conn = DriverManager.getConnection(dbURL, "root", "user1234");
		System.out.println("연결완료");
		pstmt = conn.prepareStatement(sql);
		//반복 시킬 코드
		pstmt.setString(1, id);
		pstmt.setString(2, pw);
		pstmt.setString(3, name);
		retval = pstmt.executeUpdate();
		if (retval != 1) {
			System.out.println("insert error");
		}
		//여기까지
	} catch (Exception e) {
		System.out.println("MySql데이터베이스에 문제가 있습니다.");
		System.out.println(e.getMessage());
		e.printStackTrace();
	} finally {
		if (pstmt != null) {
			try {
				pstmt.close();				
			} catch (SQLException e) {}
		}
		if (conn != null) {
			try {
				conn.close();				
			} catch (SQLException e) {}
		}
	}
	
	%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<h2> 회원가입결과</h2>
		<table width="550" border="1">
		<tr>
			<td width="100"> 아이디 </td>
			<td width="100"> 패스위드 </td>
			<td width="100"> 이름 </td>
		</tr>
<%
	ResultSet rs = null;

	try	{
	String jdbcDriver = "jdbc:mysql://localhost:3306/jspLecture_db";
	String dbUser = "root";
	String dbPass = "user1234";
	
	conn = DriverManager.getConnection(jdbcDriver, dbUser, dbPass);

		String sql = "select * from bmember";
		pstmt = conn.prepareStatement(sql);
		rs = pstmt.executeQuery();

		while(rs.next()) {
			 id = rs.getString("id");
			 pwd = rs.getString("pw");
			 name = rs.getString("name");				
%>
			<tr>
				<td width="100"> <%=id%> </td>
				<td width="100"> <%=pwd%> </td>
				<td width="100"> <%=name%> </td>				
			</tr>
<%
			}
		}
		catch(Exception e)
		{
				e.printStackTrace();
		}
		finally
		{
			if(rs != null) 
				try{rs.close();}catch(SQLException sqle){}
			if(pstmt != null) 
				try{pstmt.close();}catch(SQLException sqle){}
			if(conn != null) 
				try{conn.close();}catch(SQLException sqle){}
		}
%>
		</table>
</body>
</html>
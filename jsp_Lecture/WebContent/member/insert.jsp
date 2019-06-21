<%@ page contentType="text/html; charset=euc-kr"%>
<%@ page import="java.sql.*" %>

<%
//------- 클라이언트로부터 전달된 데이터 저장 ------------
	request.setCharacterEncoding("euc-kr");

	String id = request.getParameter("id");
	String pw = request.getParameter("pw");
	String name = request.getParameter("name");
	String pwd = null;
//---------------------------------------------------
	Connection conn = null;
	PreparedStatement pstmt = null;
	int ret=0;
	try
	{
		Class.forName("com.mysql.jdbc.Driver");
		String jdbcUrl = "jdbc:mysql://localhost:3306/jspLecture_db";
		String dbUser = "root";
		String dbPass = "user1234";
		
		conn = DriverManager.getConnection(jdbcUrl, dbUser, dbPass);

		String sql = "insert into bmember values(?,?,?)";
		pstmt = conn.prepareStatement(sql);
		pstmt.setString(1,id);
		pstmt.setString(2,pw);
		pstmt.setString(3,name);
		ret= pstmt.executeUpdate();
		if(ret!=1)
		{
			System.out.println("inset fail");
		}
	}
	catch(Exception e)
	{
		e.printStackTrace();
	}
	finally
	{
		if(pstmt != null) try{pstmt.close();}catch(SQLException sqle){}
		if(conn != null) try{conn.close();}catch(SQLException sqle){}
	}
%>

<html>
	<head> <title> 회원가입결과 </title> </head>
	<body>
		<h2> 회원가입결과</h2>
		<table width="550" border="1">
		<tr>
			<td width="100"> 아이디 </td>
			<td width="100"> 패스위드 </td>
			<td width="100"> 이름 </td>
		</tr>
		
<%
		//Connection conn = null;
		//PreparedStatement pstmt = null;
		ResultSet rs = null;

		try
		{String jdbcDriver = "jdbc:mysql://localhost:3306/jspLecture_db";
		String dbUser = "root";
		String dbPass = "user1234";
		
		conn = DriverManager.getConnection(jdbcDriver, dbUser, dbPass);

			String sql = "select * from bmember";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();

			while(rs.next())
			{
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

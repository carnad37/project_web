<%@ page contentType="text/html; cahrset=euc-kr"%>
<%@ page import = "java.sql.*" %>
<html>
	<head> <title> name </title> </head>
	<body>
<%
	request.setCharacterEncoding("euc-kr");

	String id = request.getParameter("id");
	String pw = request.getParameter("passwd");
	String name = request.getParameter("name");
	System.out.println("client : "+id+","+pw+", "+name);
	Connection conn = null;
	PreparedStatement pstmtSelect = null;
	PreparedStatement pstmtUpdate = null;
	ResultSet rs = null;
	int retVal=0;
	try
	{
		Class.forName("com.mysql.jdbc.Driver");
		String jdbcUrl = "jdbc:mysql://localhost:3306/jspLecture_db";


		String dbUser = "root";
		String dbPass = "user1234";
		
		conn = DriverManager.getConnection(jdbcUrl, dbUser, dbPass);

		String sql = "select id, pw from bmember where id = ?";
		pstmtSelect = conn.prepareStatement(sql);
		
		pstmtSelect.setString(1, id);
		rs = pstmtSelect.executeQuery();

		if( rs.next() )
		{
			String rId= rs.getString("id");
			String rPasswd = rs.getString("pw");
			System.out.println(rId+","+rPasswd);
			if ( id.equals(rId) && pw.equals(rPasswd) )
			{
				sql = "update bmember set name = ? where id = ?";
				pstmtUpdate = conn.prepareStatement(sql);
				pstmtUpdate.setString(1,name);
				pstmtUpdate.setString(2,id);
				retVal=pstmtUpdate.executeUpdate();
				System.out.println("update rerutn "+retVal);
				if(retVal!=1)
				{
					out.println("update fail");
					return;
				}
				sql = "select id, name from bmember where id = ?";
				pstmtSelect = conn.prepareStatement(sql);
				
				pstmtSelect.setString(1, id);
				rs = pstmtSelect.executeQuery();
				if( rs.next() )
				{
					rId= rs.getString("id");
					String rName=rs.getString("name");
					System.out.println("update rerutn "+retVal);
					System.out.println(rId+","+rName);
					
%>
					id:<%=rId %> | name : <%=rName %>
										
<%
				}
			}
			else
			{
				out.println("changing name fail");
			}
		}
		else
			out.println("id is not correct.");
	}
	catch(Exception e)
	{
		e.printStackTrace();
	}
	finally
	{
		if( rs != null) try{rs.close();}catch(SQLException sqle){}
		if( pstmtSelect != null) try{pstmtSelect.close();}catch(SQLException sqle){}
		if( pstmtUpdate != null) try{pstmtUpdate.close();}catch(SQLException sqle){}
		if( conn != null) try{conn.close();}catch(SQLException sqle){}
	}
%>
	</body>
</html>
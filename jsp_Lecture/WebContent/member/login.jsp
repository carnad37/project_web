<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page import = "java.sql.DriverManager" %>
<%@ page import = "java.sql.Connection" %>
<%@ page import = "java.sql.PreparedStatement" %>
<%@ page import = "java.sql.ResultSet" %>
<%@ page import = "java.sql.SQLException" %>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<body>
<%
 
	 String id = request.getParameter("id");
	 String pwd = request.getParameter("pw");
 
	Connection conn = null;
	Class.forName("com.mysql.jdbc.Driver");
	PreparedStatement pstmt = null;
	ResultSet rs=null;
	String pwDb=null;
	 try{
			 Class.forName("com.mysql.jdbc.Driver");
	        String jdbcUrl = "jdbc:mysql://localhost:3306/jspLecture_db";
	        String dbUser = "root";
	        String dbPass = "user1234";
	        String sql="select pw from bmember where id = ?";
	        conn = DriverManager.getConnection(jdbcUrl, dbUser, dbPass);
	 
	        System.out.println("console> conn : " + conn);
	        pstmt = conn.prepareStatement(sql);
	        pstmt.setString(1, id);

	       rs= pstmt.executeQuery();
	    	if(rs.isBeforeFirst())	// ������ ������
	    	{
	    		while (rs.next()) {
	    			pwDb = rs.getString("pw");
	    			System.out.println("console>  pw : "+pwDb);
	    			if(pwDb.equals(pwd)){
	    				out.println("login success");
	    			}
	    			else{
	    				out.println("login fail : pw incorrect");
	    			}
				}
	    	}
	    	else	//id �� db�� ���°��
	    	{
	    		out.println("id is not registered");
	    		System.out.println("console>  id Ʋ��");
	    	}
	    	
	    }
	 catch (Exception e) {
			System.out.println("MySql �����ͺ��̽��� ������ �ֽ��ϴ�.");
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
	 finally{
//	      ����Ǿ��� Ŀ�ؼǵ��� ��� �ݾ���� ��(��ü ������ ������ �ݴ�� �ݾ���� ��)
	        if (pstmt != null) try { pstmt.close(); } catch(SQLException ex) {}
	        if (conn != null) try { conn.close(); } catch(SQLException ex) {}
	    }
%>
</body>
</html>




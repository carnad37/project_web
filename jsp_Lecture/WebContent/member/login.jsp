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
	    	if(rs.isBeforeFirst())	// 데이터 있으면
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
	    	else	//id 가 db에 없는경우
	    	{
	    		out.println("id is not registered");
	    		System.out.println("console>  id 틀림");
	    	}
	    	
	    }
	 catch (Exception e) {
			System.out.println("MySql 데이터베이스에 문제가 있습니다.");
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
	 finally{
//	      실행되었던 커넥션들을 모두 닫아줘야 함(객체 선언한 순서의 반대로 닫아줘야 함)
	        if (pstmt != null) try { pstmt.close(); } catch(SQLException ex) {}
	        if (conn != null) try { conn.close(); } catch(SQLException ex) {}
	    }
%>
</body>
</html>




<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="java.sql.*" %>
<%@page import="java.util.*" %>
<%@page import="org.json.JSONObject" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
    Connection con= null;
	ResultSet rs = null;
	PreparedStatement pstm=null;
 	try{
		Class.forName("com.mysql.jdbc.Driver");
		con = DriverManager.getConnection("jdbc:mysql://localhost:3306/jsplecture_db","root","user1234");
		
		//2. JavaScript로 넘길 JSON Object 	생성(map형식 - key, value)
		JSONObject responseObj = new JSONObject();
		//3. JSON Object를 저장할 리스트 생성
		List empdetails = new LinkedList();
		String query = "SELECT id,name from employee";
		pstm= con.prepareStatement(query);
		
		rs = pstm.executeQuery();
		JSONObject empObj = null;
	
		while (rs.next()) {
			String name = rs.getString("name");
			int empid = rs.getInt("id");
			//4. 실제 DB내용을 저장할 JSON object 생성(map형식 - key, value)
			empObj = new JSONObject();
			empObj.put("name", name);
			empObj.put("empid", empid);
			//5. 4번에서 DB의 하나의 레코드를 저장한 JSON object를  리스트에 저장
			empdetails.add(empObj);
		}
		//6. JavaScript로 넘길 Obejct에 실제 정보가 담긴 리스트 저장
		responseObj.put("empdetails", empdetails);
		out.print(responseObj.toString());
    }
    catch(Exception e){
        e.printStackTrace();
    }finally{
    	  if(rs!= null){
    		  rs.close();
          }
        if(pstm!= null){
        	pstm.close();
        }
        if(con!= null){
            con.close();
        }
    }
	%>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ page import = "java.sql.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>전화번호로 수정할 주소를 선택해주세요</title>
<style>
	* {padding: 0; margin: 0;}
    ul {list-style-type: none;}
    div {width: 300px; margin: 0 auto; text-align: right; box-sizing: border-box; }
    li {margin-right: 20px;margin-top: 5px;}
    li h3 {text-align: left; padding: 20px 0; margin-left: 30px;}
    legend {text-align: left; margin-left: 20px; font-weight: bold;}
    fieldset {padding: 20px 0;}
    body > h3 {padding : 10px 20px;}
</style>
</head>
<body>
<%
	request.setCharacterEncoding("utf-8");
	String phone = request.getParameter("top") + "-" +  request.getParameter("middle") + "-" +  request.getParameter("bottom");

	String driver = "com.mysql.jdbc.Driver";
	String dbName = "jsplecture_db";
	String dbURL = "jdbc:mysql://localhost:3306/" + dbName;
	int post_num = 0;
	String name = null;
	String city_do = null;
	String city_si = null;
	String lot_num = null;
	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet result = null;
	try {
		Class.forName(driver);
		conn = DriverManager.getConnection(dbURL, "root", "user1234");
		String SQL = "select name, post_num, city_do, city_si, lot_num from address_db where phone = ?";
		pstmt = conn.prepareStatement(SQL);
		pstmt.setString(1, phone);
		result = pstmt.executeQuery();
		if(!result.isBeforeFirst()) {
			out.print("등록되지 않은 전화번호입니다.");
%>
	<h3><a href="Addressbook_update_phone.html">다른 전화번호로 수정대상 검색하기</a></h3>
	<h3><a href="Addressbook_menu.html">메인메뉴로 돌아가기</a></h3>
<%
		} else {
			while (result.next()) {
				name = result.getString("name");
				post_num = result.getInt("post_num");
				city_do = result.getString("city_do");
				city_si = result.getString("city_si");
				lot_num = result.getString("lot_num");
			}
%>
	<form class="" action="update_phonetoadress.jsp" method="post">
	<fieldset>
   		<legend>수정할 정보</legend>
   	    <ul>
			<li>이름 : <input type="text" name="name" value="<%= name %>"></li>
			<li>우편번호 : <input type="text" name="post_num" value="<%= post_num %>"></li>
			<li>도 : <input type="text" name="city_do" value="<%= city_do %>"></li>
			<li>시 : <input type="text" name="city_si" value="<%= city_si %>"></li>
			<li>지번 : <input type="text" name="lot_num" value="<%= lot_num %>"></li>
			<li><input type="hidden" name="phone" value="<%= phone %>"></li>			
			<li> <input type="submit" name="" value="보내기"> </li>
     	</ul>
   	</fieldset>
	</form>
<%
		}
	} catch (ClassNotFoundException e) {
		out.println("클래스를 찾을수가 없습니다.");
	} catch (SQLException e) {
		out.println("서버와의 연결에 오류가 발생했습니다.");
		out.println(e);
	} finally {
		if (pstmt != null) try {pstmt.close();} catch (SQLException e) {}
		if (conn != null) try {conn.close();} catch (SQLException e) {}
	}
%>
</body>
</html>
//package member.dao;
//import java.sql.*;
//public class MemberDao {
//	public int insertMember(String id, String pw, String name) {
//		int ret=0;
//		String driverName = "com.mysql.jdbc.Driver";
//		String DBName = "jsplecture_db";
//		String dbURL = "jdbc:mysql://localhost:3306/" + DBName;
//		String sql = "insert into bmember (?, ?, ?)";
//		Connection conn=null;
//		PreparedStatement pstmt = null;
//		int retval=0;		
//		try {
//			Class.forName(driverName);
//			conn= DriverManager.getConnection(dbURL, "root", "user1234");
//			System.out.println("DAO의 db 연결완료");
//			pstmt = conn.prepareStatement(sql);
//			pstmt.setString(1,id);
//			pstmt.setString(2,pw);
//			pstmt.setString(3,name);			
//			retval=pstmt.executeUpdate();	
//			
//			if(retval!=1) {
//				System.out.println("insert error.");
//				ret=-1;
//			}
//			System.out.println("bmember table insert 성공");
//			ret=1;
//		}
//		catch (SQLTimeoutException e) {
//			ret=-2;
//			System.out.println("time out error.");
//			System.out.println(e.getMessage());
//			e.printStackTrace();
//		}
//		catch (SQLException e) {
//			ret=-3;
//			System.out.println("access error.");
//			System.out.println(e.getMessage());
//			e.printStackTrace();
//		}
//		catch (Exception e) {
//			ret=-4;
//			System.out.println("MySql 데이터베이스에 문제가 있습니다.");
//			System.out.println(e.getMessage());
//			e.printStackTrace();
//		}
//		finally	{
//			if (pstmt != null) try { pstmt.close(); } catch(SQLException ex) {}
//			if (conn != null) try { conn.close(); } catch(SQLException ex) {}					
//		} 	
//		return ret;
//	}
//
//}

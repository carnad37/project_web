package com.test2;

import java.sql.*;


import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class BmemberDao {
	public int loginCheck(String id, String pw) {
		//2은 아이디 없음.
		//3는 비밀번호 틀림.
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int retval = 1;
			try {
			conn = getConnection();
			String sql = "select pw from bmember where id = ?";

			System.out.println("연결완료");
			pstmt = conn.prepareStatement(sql);
			//반복 시킬 코드
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			boolean idCheck = rs.isBeforeFirst();
			if (idCheck) {
				while (rs.next()) {
					String target = rs.getString("pw");
					if (!pw.equals(target)) {
						retval = 3;
					}
				}
			} else {
				retval = 2;
			}
			//여기까지
		} catch (SQLException e) {
			retval = 5;
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
		return retval;
	}
	public int updateMember(String id, String pw, String name) {
		Connection conn = null;
		PreparedStatement pstmt = null;		
		int retval = 0;
		try {
			String sql = "update bmember set pw = ?, name =? where id = ?";
			conn = getConnection();
			System.out.println("연결완료");
			pstmt = conn.prepareStatement(sql);
			//반복 시킬 코드
			pstmt.setString(1, pw);
			pstmt.setString(2, name);
			pstmt.setString(3, id);
			retval = pstmt.executeUpdate();
			if (retval != 1) {
				retval = -1;
				System.out.println("update error");
			} 
			//여기까지
		} catch (SQLException e) {
			retval = -2;
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
		return retval;
	}
	public int insertMember(String id, String pw, String name) {
		int ret = 0;
		Connection conn = null;
		PreparedStatement pstmt = null;
		int retval = 0;
		try {
			String sql = "insert into bmember values (?, ?, ?)";
			conn = getConnection();
			System.out.println("연결완료");
			pstmt = conn.prepareStatement(sql);
			//반복 시킬 코드
			pstmt.setString(1, id);
			pstmt.setString(2, pw);
			pstmt.setString(3, name);
			retval = pstmt.executeUpdate();
			if (retval != 1) {
				ret = -1;
				System.out.println("insert error");
			} else {
				ret = 1;
			}
			//여기까지
		} catch (SQLException e) {
			ret = -2;
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
		return ret;
	}
	public String searchMember(String id) {
		String name = null;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet result = null;
		try {
			conn = getConnection();
			String SQL = "select name from bmember where id = ?";
			pstmt = conn.prepareStatement(SQL);
			pstmt.setString(1, id);
			result = pstmt.executeQuery();
			boolean check = result.isBeforeFirst();
			if(check == false) {
			} else {
				while (result.next()) {
					name = result.getString("name");
				}
			}
		} catch(SQLException e) {
		} finally {
			if (pstmt != null) try {pstmt.close();} catch (SQLException e) {}
			if (conn != null) try {conn.close();} catch (SQLException e) {}
		}
		return name;
	}
	public Member getMemberInfo(String id) {
		Member member = null;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			String sql = "select * from bmember where id = ?";
			conn = getConnection();			System.out.println("연결완료");
			pstmt = conn.prepareStatement(sql);
			//반복 시킬 코드
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			boolean idCheck = rs.isBeforeFirst();
			if (idCheck) {
				while (rs.next()) {
					String name = rs.getString("name");
					String pw = rs.getString("pw");
					member = new Member(id, pw, name);
				}
			} else {
				System.out.println("error : DB data mismatch");
			}
			//여기까지
		} catch (SQLException e) {
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
		return member;
	}
	private Connection getConnection() {		
		Context context = null;
		DataSource dataSource = null;
		Connection connection = null;
		Context envContext= null;
		try {
			context = new InitialContext();
			envContext = (Context)context.lookup("java:comp/env");
			dataSource = (DataSource)envContext.lookup("jdbc/MySQLDB");
			connection = dataSource.getConnection();
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("exception : getConnection()");
		}		
		return connection;
	}
}

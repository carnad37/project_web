package com.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import org.json.JSONObject;

import com.Dto.BoardDTO;

public class BoardDAO {
	public int write(BoardDTO dto) {
		int retval = 0;
		String sqlQ = "SELECT MAX(bId) AS MAX FROM board";
		String sqlU = "INSERT INTO board(bName, bTitle, bContent, bGroup, bHit, bStep, bIndent, bDate) VALUES(?, ?, ?, ?, 0, 0, 0, CURDATE())";		
		Connection conn = null;
		Statement stmt = null;
		PreparedStatement pstmt = null; 
		ResultSet rs = null;
		int group = 0;
		try {
			conn = getConnection();
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sqlQ);
			boolean check = rs.isBeforeFirst();
			if (check == false) {
				System.out.println("Query Error");
			} else {
				while (rs.next()) {
					group = rs.getInt("MAX") + 1;
				}
			}
			pstmt = conn.prepareStatement(sqlU);
			pstmt.setString(1, dto.getbName());
			pstmt.setString(2, dto.getbTitle());
			pstmt.setString(3, dto.getbContent());
			pstmt.setInt(4, group);
			retval = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (rs != null) try {rs.close();} catch (SQLException e) {}
			if (stmt != null) try {stmt.close();} catch (SQLException e) {}
			if (pstmt != null) try {pstmt.close();} catch (SQLException e) {}
			if (conn != null) try {conn.close();} catch (SQLException e) {}			
		}
		return retval;
	}
	
	public ArrayList<BoardDTO> list() {
		ArrayList<BoardDTO> bdto = null;
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		String SQL = "SELECT * FROM board";
		try {
			conn = getConnection();
			stmt = conn.createStatement();
			rs = stmt.executeQuery(SQL);
			boolean check = rs.isBeforeFirst();
			if (check == false) {
				System.out.println("DB ERROR");
			} else {
				bdto = new ArrayList<BoardDTO>();
				while (rs.next()) {
					BoardDTO dto = new BoardDTO();
					dto.setbId(rs.getInt("bId"));
					dto.setbName(rs.getString("bName"));
					dto.setbTitle(rs.getString("bTitle"));
					dto.setbContent(rs.getString("bContent"));
					dto.setbHit(rs.getInt("bHit"));
					dto.setbGroup(rs.getInt("bGroup"));
					dto.setbStep(rs.getInt("bStep"));
					dto.setbIndent(rs.getInt("bIndent"));
					dto.setbDate(rs.getTimestamp("bDate"));
					bdto.add(dto);
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (rs != null) try {rs.close();} catch (SQLException e) {}
			if (stmt != null) try {stmt.close();} catch (SQLException e) {}
			if (conn != null) try {conn.close();} catch (SQLException e) {}			
		}
		return bdto;
	}

	private int upHit(int bId) {
		int retval = 0;
		Connection conn = null;
		PreparedStatement pstmt = null;
		String SQL = "UPDATE board SET bHit = bHit+1 WHERE bId= ?";
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(SQL);
			pstmt.setInt(1, bId);
			retval = pstmt.executeUpdate();
			if (retval != 1) {
				System.out.println("HIT UPDATE ERROR");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (pstmt != null) try {pstmt.close();} catch (SQLException e) {}
			if (conn != null) try {conn.close();} catch (SQLException e) {}			
		}
		return retval;
	}
	
	public int reWrite(int bId, String name, String title, String content) {
		int retval = 0;
		Connection conn = null;
		PreparedStatement pstmt = null;
		String SQL = "UPDATE board SET bName = ?, bTitle = ?, bContent = ? WHERE bId= ?";
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(SQL);
			pstmt.setString(1, name);
			pstmt.setString(2, title);
			pstmt.setString(3, content);
			pstmt.setInt(4, bId);
			retval = pstmt.executeUpdate();
			if (retval != 1) {
				System.out.println("HIT UPDATE ERROR");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (pstmt != null) try {pstmt.close();} catch (SQLException e) {}
			if (conn != null) try {conn.close();} catch (SQLException e) {}			
		}
		return retval;
	}
	
	public BoardDTO callContent(int bId) {
		
		upHit(bId);
		
		BoardDTO bdto = null;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String SQL = "SELECT * FROM board WHERE bId = ?";
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(SQL);
			pstmt.setInt(1, bId);
			rs = pstmt.executeQuery();
			boolean check = rs.isBeforeFirst();
			if (check == false) {
				System.out.println("DB ERROR");
			} else {
				bdto = new BoardDTO();
				while (rs.next()) {
					bdto.setbId(rs.getInt("bId"));
					bdto.setbName(rs.getString("bName"));
					bdto.setbTitle(rs.getString("bTitle"));
					bdto.setbContent(rs.getString("bContent"));
					bdto.setbHit(rs.getInt("bHit"));
					bdto.setbGroup(rs.getInt("bGroup"));
					bdto.setbStep(rs.getInt("bStep"));
					bdto.setbIndent(rs.getInt("bIndent"));
					bdto.setbDate(rs.getTimestamp("bDate"));
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (rs != null) try {rs.close();} catch (SQLException e) {}
			if (pstmt != null) try {pstmt.close();} catch (SQLException e) {}
			if (conn != null) try {conn.close();} catch (SQLException e) {}			
		}
		return bdto;
	}
	
	public int delete(int bId) {
		int retval = 0;
		Connection conn = null;
		PreparedStatement pstmt = null;
		String SQL = "DELETE FROM board WHERE bId = ?";
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(SQL);
			pstmt.setInt(1, bId);
			retval = pstmt.executeUpdate();
			if (retval != 1) {
				System.out.println("TARGET DELETE ERROR");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (pstmt != null) try {pstmt.close();} catch (SQLException e) {}
			if (conn != null) try {conn.close();} catch (SQLException e) {}			
		}
		return retval;
	}
	
	public void updateCommit() {
		Connection conn = null;
		try {
			conn = getConnection();
			conn.commit();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (conn != null) try {conn.close();} catch (SQLException e) {}
		}
	}

	
	public void updateRollback() {
		Connection conn = null;
		try {
			conn = getConnection();
			conn.rollback();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (conn != null) try {conn.close();} catch (SQLException e) {}
		}
	}
	
	public void updateDBStart() {
		Connection conn = null;
		String SQL = "BEGIN TRAN	";
		Statement stmt = null;
		try {
			conn = getConnection();
			stmt = conn.createStatement();
			stmt.executeQuery(SQL);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (stmt != null) try {stmt.close();} catch (SQLException e) {}
			if (conn != null) try {conn.close();} catch (SQLException e) {}
		}
	}
	
	public void updateDBCommit() {
		Connection conn = null;
		String SQL = "COMMIT TRAN";
		Statement stmt = null;
		try {
			conn = getConnection();
			stmt = conn.createStatement();
			stmt.executeUpdate(SQL);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (stmt != null) try {stmt.close();} catch (SQLException e) {}
			if (conn != null) try {conn.close();} catch (SQLException e) {}
		}
	}
	
	public void updateDBRollback() {
		Connection conn = null;
		String SQL = "ROLLBACK TRAN";
		Statement stmt = null;
		try {
			conn = getConnection();
			stmt = conn.createStatement();
			stmt.executeQuery(SQL);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (stmt != null) try {stmt.close();} catch (SQLException e) {}
			if (conn != null) try {conn.close();} catch (SQLException e) {}
		}
	}
	
	public void updateTest(String str) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "INSERT INTO test_table(val) VALUES(?)";
		try {
			
			conn = getConnection();
			conn.setAutoCommit(false);

			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, str);
			pstmt.executeUpdate();
			System.out.println("post : " + conn.hashCode());
			conn.commit();
			conn.setAutoCommit(true);
//			pstmt.executeUpdate();
//			conn.commit();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (pstmt != null) try {pstmt.close();} catch (SQLException e) {}
			if (conn != null) try {conn.close();} catch (SQLException e) {}
		}
	}
	
	public JSONObject getJSONObject() {
		Connection conn = null;
		ResultSet rs = null;
		PreparedStatement pstmt = null;
		JSONObject responseObj = null;
		try {
			conn = getConnection();
			responseObj = new JSONObject();
			
			List<Object> empdetail = new LinkedList<Object>();
			String SQL = "SELECT id, name FROM employee";
			pstmt = conn.prepareStatement(SQL);
			
			rs = pstmt.executeQuery();
			JSONObject empObj = null;
			while (rs.next()) {
				String name = rs.getString("name");
				int empid = rs.getInt("id");
				empObj = new JSONObject();
				empObj.put("name", name);
				empObj.put("empid", empid);
				empdetail.add(empObj);
			}
			responseObj.put("empdetails", empdetail);
		} catch (Exception e) {
			// TODO: handle exception
		} finally{
	    	if(rs!= null) try {rs.close();} catch (Exception e) {}
	    	if(pstmt!= null) try {pstmt.close();} catch (Exception e) {}
	    	if(conn!= null) try {conn.close();} catch (Exception e) {}

		}
		return responseObj;
	}
	
	
	private Connection getConnection() throws SQLException {
		Context context = null;
		Context envContext = null;
		DataSource dataSource = null;
		Connection conn = null;
		try {
			context = new InitialContext();
			envContext = (Context)context.lookup("java:comp/env");
			dataSource = (DataSource)envContext.lookup("jdbc/MyJSPDB");
			conn = dataSource.getConnection();
		} catch (NamingException e) {
			e.printStackTrace();
		}
		return conn;
	}
}

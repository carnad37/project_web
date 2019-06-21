package com.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class testDAO {
	
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
	
	public void updateTest(String str) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "INSERT INTO test_table(test) VALUES(?)";
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, str);
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (pstmt != null) try {pstmt.close();} catch (SQLException e) {}
			if (conn != null) try {conn.close();} catch (SQLException e) {}
		}
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

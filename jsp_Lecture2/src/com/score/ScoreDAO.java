package com.score;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class ScoreDAO {
	//query
	public Student getStudentInfo(String name) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		Student student = null;
		ResultSet rs = null;
		try {
			String sql = "SELECT * FROM SCORE WHERE NAME = ?";
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, name);
			rs = pstmt.executeQuery();
			boolean check = rs.isBeforeFirst();
			if (check == false) {
				System.out.println("query error : NO Data");
			} else {
				while(rs.next()) {
					student = new Student();
					student.setName(name);
					student.setLan(rs.getInt("LAN"));
					student.setEng(rs.getInt("ENG"));
					student.setMat(rs.getInt("MAT"));
					student.setSci(rs.getInt("SCI"));
					student.setCom(rs.getInt("COM"));
					student.setMus(rs.getInt("MUS"));
					student.setPhy(rs.getInt("PHY"));
				}
				System.out.println("query success");
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {
			if (pstmt != null) try{pstmt.close();} catch (SQLException e) {};
			if (conn != null) try{conn.close();} catch (SQLException e) {};
		}
		return student;
	}
	public double getStudentAvg(String name) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		double avg = 0;
		ResultSet rs = null;
		try {
			String sql = "SELECT NAME, (LAN + ENG + MAT + SCI + COM + MUS + PHY)/7 AS AVG FROM SCORE WHERE NAME = ?";
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, name);
			rs = pstmt.executeQuery();
			boolean check = rs.isBeforeFirst();
			if (check == false) {
				System.out.println("query error : NO Data");
			} else {
				while(rs.next()) {
					avg = rs.getInt("AVG");
				}
				System.out.println("query success");
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {
			if (pstmt != null) try{pstmt.close();} catch (SQLException e) {};
			if (conn != null) try{conn.close();} catch (SQLException e) {};
		}
		return avg;
	}
	
	public List<Student> getStudentRank() {
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		List<Student> stuList = null;
		try {
			String sql = "SELECT NAME, (LAN + ENG + MAT + SCI + COM + MUS + PHY) AS AVG FROM SCORE ORDER BY AVG DESC";
			conn = getConnection();
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			boolean check = rs.isBeforeFirst();
			if (check == false) {
				System.out.println("ERROR : NO Data");
			} else {
				stuList = new ArrayList<Student>();
				int count = 1;
				while(rs.next()) {
					Student student = new Student();
					student.setName(rs.getString("name"));
					student.setRank(count);
					stuList.add(student);
					count++;
				}
				System.out.println("query success");
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {
			if (stmt != null) try{stmt.close();} catch (SQLException e) {};
			if (conn != null) try{conn.close();} catch (SQLException e) {};
		}
		return stuList;
	}
	//update
	public String setStudentInfo(Student student) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		int retval = 0;
		String result = null;
		try {
			String sql = "INSERT INTO SCORE(NAME, LAN, ENG, MAT, SCI, COM, MUS, PHY) VALUES( ?, ?, ?, ?, ?, ?, ?, ?)";
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, student.getName());
			pstmt.setInt(2, student.getLan());
			pstmt.setInt(3, student.getEng());
			pstmt.setInt(4, student.getMat());
			pstmt.setInt(5, student.getSci());
			pstmt.setInt(6, student.getCom());
			pstmt.setInt(7, student.getMus());
			pstmt.setInt(8, student.getPhy());
			retval = pstmt.executeUpdate();
			if (retval != 1) {
				System.out.println("Insert Fail..");
				result = "업데이트에 실패했습니다.";
			} else {
				System.out.println("Insert Sucess");
				result = "업데이트에 성공했습니다.";
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {
			if (pstmt != null) try{pstmt.close();} catch (SQLException e) {};
			if (conn != null) try{conn.close();} catch (SQLException e) {};
		}
		return result;
	}
	
	public Map<String, Double> getSubjectAvg() {
		Map<String, Double> subjectAvg = null;
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		try {
			conn = getConnection();
			stmt = conn.createStatement();
			String sql = "SELECT AVG(LAN) AS AVG_LAN, AVG(ENG) AS AVG_ENG, AVG(MAT) AS AVG_MAT, AVG(SCI) AS AVG_SCI, AVG(COM) AS AVG_COM, AVG(MUS) AS AVG_MUS, AVG(PHY) AS AVG_PHY FROM SCORE";
			rs = stmt.executeQuery(sql);
			boolean check = rs.isBeforeFirst();
			if(check == false) {
				System.out.println("NO DATA");
			} else {
				System.out.println("LOAD DATA");
				subjectAvg = new HashMap<String, Double>();
				while (rs.next()) {
					subjectAvg.put("AVG_LAN", rs.getDouble("AVG_LAN"));
					subjectAvg.put("AVG_ENG", rs.getDouble("AVG_ENG"));
					subjectAvg.put("AVG_MAT", rs.getDouble("AVG_MAT"));
					subjectAvg.put("AVG_SCI", rs.getDouble("AVG_SCI"));
					subjectAvg.put("AVG_COM", rs.getDouble("AVG_COM"));
					subjectAvg.put("AVG_MUS", rs.getDouble("AVG_MUS"));
					subjectAvg.put("AVG_PHY", rs.getDouble("AVG_PHY"));
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
		} finally {
			if (stmt != null) try{stmt.close();} catch (SQLException e) {};
			if (conn != null) try{conn.close();} catch (SQLException e) {};
		}
		return subjectAvg;
	}
	
	private Connection getConnection() {
		Context context = null;
		DataSource dataSource = null;
		Connection connection = null;
		Context envContext = null;
		try {
			context = new InitialContext();
			envContext = (Context)context.lookup("java:comp/env");
			dataSource = (DataSource)envContext.lookup("jdbc/MySQLDB");
			connection = dataSource.getConnection();
		} catch (NamingException e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
		}
		return connection;		
	}
	
}

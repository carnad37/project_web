package com.student;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class StudentDAO {
	
	public int STUDENT_INSERT = 0;
	public int NAME_SEARCH = 1;
	public int ID_SEARCH = 2;
	public int SUBJECT_SEARCH = 3;
	public int ERROR = 0;
	public boolean PASS = true;
	public boolean EMPTY = false;
	
	public int insertUpdateDB(Student student, int function) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = null;
		int retval = 0;
		try {
			sql = "INSERT INTO STUDENT(NAME, PHONE, STUDENT_ID, SUBJECT) VALUES(?,?,?,?)";
//			Class.forName(driver);
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, student.getName());
			pstmt.setString(2, student.getPhone());
			pstmt.setString(3, student.getStudent_id());
			pstmt.setString(4, student.getSubject());
			retval = pstmt.executeUpdate();
			if (retval != 1) {
				retval = ERROR;
			}
//		} catch (ClassNotFoundException e) {
//			System.out.println(e.getMessage());
//			retval = ERROR;
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			retval = ERROR;
		}
		return retval;
	}

	public List<Student> searchQueryDB(String target, int function) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		List<Student> stuList = null;
		ResultSet rs = null;
		String sql = null;
		Student student = null;
		try {
			if (function == NAME_SEARCH) {
				sql = "SELECT * FROM STUDENT WHERE NAME = ?";
			} else if (function == ID_SEARCH) {
				sql = "SELECT * FROM STUDENT WHERE STUDENT_ID = ?";
			} else if (function == SUBJECT_SEARCH) {
				sql = "SELECT * FROM STUDENT WHERE SUBJECT = ?";
			}
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, target);
			rs = pstmt.executeQuery();
			boolean rsCheck = rs.isBeforeFirst();
			if (rsCheck == EMPTY) {
				System.out.println("DB : NO DATA");
			} else {
				stuList = new ArrayList<Student>();
				while (rs.next()) {
					String name = rs.getString("name");
					String phone = rs.getString("phone");
					String student_id = rs.getString("student_id");
					System.out.println(student_id);
					String subject = rs.getString("subject");
					student = new Student(name, student_id, phone, subject);
					stuList.add(student);
				}
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			System.out.println("DB : SQL ERROR");
		}
		return stuList;
	}
	
	private Connection getConnection() {
		Connection conn = null;
		Context context = null;
		Context envContext = null;
		DataSource dataSource = null;
		try {
			context = new InitialContext();
			envContext = (Context)context.lookup("java:comp/env");
			dataSource = (DataSource)envContext.lookup("jdbc/MySQLDB");
			conn = dataSource.getConnection();
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
		}
		return conn;
	}
}

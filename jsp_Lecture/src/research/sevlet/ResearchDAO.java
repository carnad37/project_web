package research.sevlet;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import research.main.Research;
import research.main.UnitQA;

public class ResearchDAO {
//	public int createResearch(Research research) {
//		int retVal = 0;
//		Connection conn = null;
//		String sql = "INSERT INTO "
//		
//	}
	public static final int REGEDIT = 1;
	public static final int UNREGEDIT = 2;
	public static final int SAVE = 0;
	public static final int LOAD = 1;
	public static final int UPDATE = 2;
	public static final int DELETE = 3;
	public static final int NO_FUNCTION = 0;
	public static final int CREATE_RESEARCH = 1;
	public static final int CREATE_QUESTION_TABLE = 2;
	public static final int INPUT_RESEARCH = 3;
	public static final int MODIFY_RESEARCH =4;
	public static final int SELECT_TITLE = 1;
	public static final int SELECT_RESEARCH_DB = 2;

	private void createResearch(Research research, PreparedStatement pstmt) throws SQLException	{		
		pstmt.setString(1, research.getTitle());
		pstmt.setString(2, research.getCustomer());
		pstmt.setString(3, research.getSubject());
		pstmt.setInt(4, research.getMax_qnum());
		pstmt.setString(5, research.getOpendate());
		pstmt.setString(6, research.getClosedate());
	}
	
	public int updateQAToDB(UnitQA unitQA, String SQL) {
		int retval = 0;
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(SQL);
			int count = 1;
			pstmt.setString(count, unitQA.getQuestion());
			List<String> answerList = unitQA.getAnswer();
			for (String answer : answerList) {
				count++;
				pstmt.setString(count, answer);
			}
			retval = pstmt.executeUpdate();
			if (retval != 1) {
				conn.rollback();
			} else {
				conn.commit();
			}			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (pstmt != null) try {pstmt.close();} catch (SQLException e) {}
			if (conn != null) try {conn.close();} catch (SQLException e) {}
		}
		return retval;
	}
	
	public int createTableToDB(String SQL) {
		int retval = 0;
		Connection conn = null;
		Statement stmt = null;
		try {
			conn = getConnection();
			stmt = conn.createStatement();
			retval = stmt.executeUpdate(SQL);
			if (retval != 1) {
				conn.rollback();
			} else {
				conn.commit();
			}			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (stmt != null) try {stmt.close();} catch (SQLException e) {}
			if (conn != null) try {conn.close();} catch (SQLException e) {}
		}
		return retval;
	}
	
	public int connectDBToUapdate(Research research, int function) {
		int retval = 0;
		Connection conn = null;
		PreparedStatement pstmt = null;
		String SQL = null;
		try {
			int maxAnswerNumber = research.getMaxAnswerNumber();
			conn = getConnection();
			if (function == CREATE_RESEARCH) {
				SQL = "insert into research_info(title, customer, subject, question_number, open_date, close_date, regedit) values( ?, ?, ?, ?, ?, ?, 1)";
				pstmt = conn.prepareStatement(SQL);
				createResearch(research, pstmt);
				retval = pstmt.executeUpdate();
				if (retval != 1) {
					conn.rollback();
					System.out.println("DB : rollback");
				} else {
					conn.commit();
					System.out.println("DB : commit");
				}
			}
//			else if (function == CREATE_QUESTION_TABLE) {
//				SQL = makeCreateTableSQL(maxAnswerNumber, research.getResearch_id());
//				pstmt = conn.prepareStatement(SQL);
//				retval = pstmt.executeUpdate();
//				if (retval != 1) {
//					conn.rollback();
//				} else {
//					conn.commit();
//				}
//				function = INPUT_RESEARCH;
//			}
//			else if (function == INPUT_RESEARCH) {
//				SQL = makeInsertDataSQL(maxAnswerNumber, research.getResearch_id());
//				pstmt = conn.prepareStatement(SQL);
//				
//				List<UnitQA> listQA = research.getListQA();
//				for (UnitQA unitQA : listQA) {
//					int count = 1;
//					pstmt.setString(count, unitQA.getQuestion());
//					List<String> answerList = unitQA.getAnswer();
//					for (String answer : answerList) {
//						count++;
//						pstmt.setString(count, answer);
//					}
//					retval = pstmt.executeUpdate();
//					if (retval != 1) {
//						conn.rollback();
//						break;
//					} else {
//						conn.commit();
//					}
//				}
//				function = NO_FUNCTION;
//			}
//			else if (function == MODIFY_RESEARCH) {
//				SQL = "insert into research_info (title, customer, subject, question_number, open_date, close_date) values( ?, ?, ?, ?, ?, ?)";
//				pstmt = createResearch(research, pstmt);
//				pstmt.executeUpdate();
//			}
			pstmt = conn.prepareStatement(SQL);

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (pstmt != null) try {pstmt.close();} catch (SQLException e) {}
			if (conn != null) try {conn.close();} catch (SQLException e) {}
		}
//		if(function == INPUT_RESEARCH) {
//			connectDBToUapdate(research, function);			
//		}
		return retval;
	}
	
	private Connection getConnection() {
		Connection connection = null;
		Context context = null;
		Context envContext = null;
		DataSource dataSource = null;
		try {
			context = new InitialContext();
			envContext = (Context)context.lookup("java:comp/env");
			dataSource = (DataSource)envContext.lookup("jdbc/MySQLDB");
			connection = dataSource.getConnection();
			connection.setAutoCommit(false);
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
		}
		return connection;
	}
}

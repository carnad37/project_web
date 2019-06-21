//package research.sevlet;
//
//import java.io.IOException;
//import java.util.ArrayList;
//import java.util.List;
//
//import javax.servlet.ServletException;
//import javax.servlet.annotation.WebServlet;
//import javax.servlet.http.HttpServlet;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import javax.servlet.http.HttpSession;
//
//import research.main.Research;
//import research.main.UnitQA;
//
///**
// * Servlet implementation class ResearchFrontConn
// */
//@WebServlet("*.do")
//public class ResearchFrontConn extends HttpServlet {
//	private static final long serialVersionUID = 1L;
//       
//    /**
//     * @see HttpServlet#HttpServlet()
//     */
//    public ResearchFrontConn() {
//        super();
//        // TODO Auto-generated constructor stub
//    }
//
//	/**
//	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
//	 */
//	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		actionDo(request, response);
//	}
//
//	/**
//	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
//	 */
//	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		actionDo(request, response);
//	}
//
//	protected void actionDo(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		request.setCharacterEncoding("UTF-8");
//		String uri = request.getRequestURI();
//		int start = uri.lastIndexOf("\\/");
//		String action = uri.substring(start + 1);
//		
//		if (action.equals("create.do")) {
//			String customer = request.getParameter("CUSTOMER");
//			String title = request.getParameter("TITLE");
//			String subject = request.getParameter("SUBJECT");
//			int max_qnum = Integer.parseInt(request.getParameter("MAX_QNUM"));
//			int max_anum = Integer.parseInt(request.getParameter("MAX_ANUM"));
//			String open = request.getParameter("OPEN");
//			String close = request.getParameter("CLOSE");
//			Research research = new Research(title, customer, subject, max_qnum, max_anum, open, close);
//			
//			ResearchDAO dao = new ResearchDAO();
//			HttpSession session = request.getSession();
//			String function = "CREATE_RESEARCH";
//			
//			int retval = dao.connectDBToUapdate(research, ResearchDAO.CREATE_RESEARCH);
//			if (retval != 1) {
//				System.out.println("SQLDB ERROR : data insert error");
//			} else {
//				String SQL = makeCreateTableSQL(research.getResearch_id());
//				dao.createTableToDB(SQL);
//				if (retval != 1) {
//					System.out.println("SQLDB ERROR : can't make research table");
//					retval = -1;
//				} else {
//					session.setAttribute("research", research);
//				}
//			}
//			session.setAttribute("function", function);
//			session.setAttribute("result", retval);
//			response.sendRedirect("research_result.jsp");
//			return;
//		} else if (action.equals("question.do")) {
//			String str_Anum = request.getParameter("MAX_ANUM");
//			HttpSession session = request.getSession();
//			int maxAnum = 0;
//			try {
//				maxAnum = Integer.parseInt(str_Anum);
//			} catch (NumberFormatException e) {
//				session.setAttribute("error", "NMExc");
//				System.out.println("NumberFormatException");
//				response.sendRedirect("research_question.jsp");
//				return;
//			}
//			String question = request.getParameter("QUESTION");
//			session.setAttribute("QUESTION", question);
//			session.setAttribute("MAX_ANUM", maxAnum);
//			response.sendRedirect("research_answer.jsp");
//			return;
//		} else if (action.equals("answer.do")) {
//			request.setCharacterEncoding("UTF-8");
//			HttpSession session = request.getSession();
//			Research research = (Research)session.getAttribute("research");
//			List<String> answer = new ArrayList<String>();
//			String questioin = (String)session.getAttribute("QUESTION");
//			int maxAnum = (Integer)session.getAttribute("MAX_ANUM");
//			for (int i = 1; i <= maxAnum; i++) {
//				String key = i + "_ans";
//				String unitAnswer = (String)session.getAttribute(key);
//				answer.add(unitAnswer);
//			}
//			UnitQA unitQA = new UnitQA();
//			unitQA.setQuestion(questioin);
//			unitQA.setAnswer(answer);
//			String SQL = makeCreateTableSQL(research.getResearch_id());
//			ResearchDAO dao = new ResearchDAO();
//			dao.createTableToDB(SQL);
//		} else {
//			System.out.println("SERVLET ERROR : NOT FOUND ACTION. CHECK FORM TAG ACTION.");
//		}
//	}
//	private String makeCreateTableSQL(int research_id) {
//		String SQL = "create table " + "research_" + research_id + " ( qid int(3) primary key Auto_increment, question varchar(100) not null, answer_1 varchar(50))";
////		for (int i = 2; i <= maxAnswerNumber; i++) {
////			endSQL += ", " + "answer_" + i + " varchar(50)";
////		}
////		endSQL += ")";
//		return SQL;
//	}
//	
//	private String makeInsertDataSQL(int maxAnswerNumber, int research_id) {
//		String startSQL = "insert into " + "research_" + research_id + "  values ( ?";
//		String endSQL = "";
//		for (int i = 2; i <= maxAnswerNumber; i++) {
//			endSQL += ", " + "?";
//		}
//		endSQL += ")";
//		return startSQL + endSQL;
//	}
//	
//	private String makeAddAnswerColumn(int answerNum, int addAnswerNum) {
//		String SQL = null;
//		return SQL;
//	}
//}

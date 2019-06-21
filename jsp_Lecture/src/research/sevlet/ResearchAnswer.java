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
// * Servlet implementation class ResearchAnswer
// */
//@WebServlet("/research/ResearchAnswer")
//public class ResearchAnswer extends HttpServlet {
//	private static final long serialVersionUID = 1L;
//       
//    /**
//     * @see HttpServlet#HttpServlet()
//     */
//    public ResearchAnswer() {
//        super();
//        // TODO Auto-generated constructor stub
//    }
//
//	/**
//	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
//	 */
//	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		// TODO Auto-generated method stub
//		response.getWriter().append("Served at: ").append(request.getContextPath());
//	}
//
//	/**
//	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
//	 */
//	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		request.setCharacterEncoding("UTF-8");
//		HttpSession session = request.getSession();
//		Research research = (Research)session.getAttribute("research");
//		List<String> answer = new ArrayList<String>();
//		String questioin = (String)session.getAttribute("QUESTION");
//		int maxAnum = (Integer)session.getAttribute("MAX_ANUM");
//		for (int i = 1; i <= maxAnum; i++) {
//			String key = i + "_ans";
//			String unitAnswer = (String)session.getAttribute(key);
//			answer.add(unitAnswer);
//		}
//		UnitQA unitQA = new UnitQA();
//		unitQA.setQuestion(questioin);
//		unitQA.setAnswer(answer);
////		ResearchSQL rSQL = new ResearchSQL();
////		String SQL = rSQL.makeCreateTableSQL(research.getResearch_id());
////		ResearchDAO dao = new ResearchDAO();
////		dao.createTableToDB(SQL);
//		
//	}
//
//}

package com.score;

import java.io.IOException;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class Score_Print_SubAvg
 */
@WebServlet("/score/Score_Print_SubAvg")
public class Score_Print_SubAvg extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Score_Print_SubAvg() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ScoreDAO dao = new ScoreDAO();
		HttpSession session = request.getSession();
		Map<String, Double> subAvg = dao.getSubjectAvg();
		if (subAvg != null) {
			session.setAttribute("subAvg", subAvg);
			session.setAttribute("result", "SAVG_PASS");
			System.out.println("score print subAvg sucess");

		} else {
			session.setAttribute("result", "SAVG_FAIL");
			System.out.println("score print subAvg fail..");

		}
		response.sendRedirect("result.jsp");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

}

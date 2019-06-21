package com.score;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class Score_Search_Avg
 */
@WebServlet("/score/Score_Search_Avg")
public class Score_Search_Avg extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Score_Search_Avg() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String name = request.getParameter("name");
		
		ScoreDAO dao = new ScoreDAO();
		HttpSession session = request.getSession();
		double avg = dao.getStudentAvg(name);
		if(avg != 0) {
			avg *= 10;
			avg = Math.round(avg);
			avg /= 10;
			session.setAttribute("avg", avg);
			session.setAttribute("result", "AVG_PASS");
			session.setAttribute("name", name);
			System.out.println("score Avg search sucess");
		} else {
			System.out.println("score Avg search fail");
			session.setAttribute("result", "AVG_FAIL");
		}
		response.sendRedirect("result.jsp");
	}

}

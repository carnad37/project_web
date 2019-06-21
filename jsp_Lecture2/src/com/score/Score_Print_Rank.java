package com.score;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class Score_Print_Rank
 */
@WebServlet("/score/Score_Print_Rank")
public class Score_Print_Rank extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Score_Print_Rank() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ScoreDAO dao = new ScoreDAO();
		HttpSession session = request.getSession();
		List<Student> stuList = dao.getStudentRank();
		if (stuList != null) {
			session.setAttribute("stuList", stuList);
			session.setAttribute("stuListLength", stuList.size());
			session.setAttribute("result", "RANK_PASS");
			System.out.println("score print rank sucess");			
		} else {
			session.setAttribute("result", "RANK_FAIL");
			System.out.println("score print rank fail..");
		}
		response.sendRedirect("result.jsp");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}

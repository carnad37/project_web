package com.score;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class Score_print
 */
@WebServlet("/score/Score_Print")
public class Score_Print extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Score_Print() {
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
		Student student = dao.getStudentInfo(name);
		if (student != null) {
			session.setAttribute("result", "PRINT_PASS");
			session.setAttribute("student", student);
			System.out.println("score print pass");
		} else {
			session.setAttribute("result", "PRINT_FAIL");
			System.out.println("score print fail");
		}
		response.sendRedirect("result.jsp");
	}

}

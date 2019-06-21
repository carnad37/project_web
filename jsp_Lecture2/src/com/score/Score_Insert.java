package com.score;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class Score_Insert
 */
@WebServlet("/score/Score_Insert")
public class Score_Insert extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Score_Insert() {
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
		int lan = Integer.parseInt(request.getParameter("lan"));
		int mat = Integer.parseInt(request.getParameter("mat"));
		int eng = Integer.parseInt(request.getParameter("eng"));
		int sci = Integer.parseInt(request.getParameter("sci"));
		int com = Integer.parseInt(request.getParameter("com"));
		int mus = Integer.parseInt(request.getParameter("mus"));
		int phy = Integer.parseInt(request.getParameter("phy"));

		Student student = new Student();
		student.setCom(com);
		student.setEng(eng);
		student.setLan(lan);
		student.setMat(mat);
		student.setMus(mus);
		student.setName(name);
		student.setPhy(phy);
		student.setSci(sci);
		
		HttpSession session = request.getSession();
		ScoreDAO dao = new ScoreDAO();
		String result = dao.setStudentInfo(student);
		session.setAttribute("result", "INSERT");
		session.setAttribute("insert", result);
		response.sendRedirect("result.jsp");
	}

}

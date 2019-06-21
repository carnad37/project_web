//package com.student;
//
//import java.io.IOException;
//import java.util.List;
//
//import javax.servlet.ServletException;
//import javax.servlet.annotation.WebServlet;
//import javax.servlet.http.HttpServlet;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import javax.servlet.http.HttpSession;
//
///**
// * Servlet implementation class StudentIDSearch
// */
//@WebServlet("/student/StudentIDSearch")
//public class StudentIDSearch extends HttpServlet {
//	private static final long serialVersionUID = 1L;
//       
//    /**
//     * @see HttpServlet#HttpServlet()
//     */
//    public StudentIDSearch() {
//        super();
//        // TODO Auto-generated constructor stub
//    }
//
//	/**
//	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
//	 */
//	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		// TODO Auto-generated method stub
//	}
//
//	/**
//	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
//	 */
//	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		request.setCharacterEncoding("UTF-8");		
//		HttpSession session = request.getSession();
//		String student_id = request.getParameter("student_id");
//		
//		StudentDAO dao = new StudentDAO();
//		List<Student> stuList = dao.searchQueryDB(student_id, dao.ID_SEARCH);
//		if (stuList != null) {
//			session.setAttribute("stuList", stuList);
//			session.setAttribute("result", "ID");
//		} else {
//			session.setAttribute("result", "등록되지 않은 학번입니다.");
//		}
//		response.sendRedirect("result.jsp");
//	}
//}

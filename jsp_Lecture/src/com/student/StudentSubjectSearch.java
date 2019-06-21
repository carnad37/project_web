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
// * Servlet implementation class StudentSubjectSearch
// */
//@WebServlet("/student/StudentSubjectSearch")
//public class StudentSubjectSearch extends HttpServlet {
//	private static final long serialVersionUID = 1L;
//       
//    /**
//     * @see HttpServlet#HttpServlet()
//     */
//    public StudentSubjectSearch() {
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
//		String subject = request.getParameter("subject");
//		
//		StudentDAO dao = new StudentDAO();
//		List<Student> stuList = dao.searchQueryDB(subject, dao.SUBJECT_SEARCH);
//		if (stuList != null) {
//			session.setAttribute("stuList", stuList);
//			session.setAttribute("result", "subject");
//		} else {
//			session.setAttribute("result", "등록되지 않은 학과입니다.");
//		}
//		response.sendRedirect("result.jsp");
//	}
//
//}

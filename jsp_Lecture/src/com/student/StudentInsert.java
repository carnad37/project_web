//package com.student;
//
//import java.io.IOException;
//import javax.servlet.ServletException;
//import javax.servlet.annotation.WebServlet;
//import javax.servlet.http.HttpServlet;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import javax.servlet.http.HttpSession;
//
///**
// * Servlet implementation class StudentInsert
// */
//@WebServlet("/student/StudentInsert")
//public class StudentInsert extends HttpServlet {
//	private static final long serialVersionUID = 1L;
//       
//    /**
//     * @see HttpServlet#HttpServlet()
//     */
//    public StudentInsert() {
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
//		String name = request.getParameter("name");
//		String phone = request.getParameter("first") + "-" + request.getParameter("second") + "-" + request.getParameter("third");
//		String student_id = request.getParameter("student_id");
//		String subject = request.getParameter("subject");
//		
//		StudentDAO dao = new StudentDAO();
//		Student student = new Student(name, student_id, phone, subject);
//		
//		int retval = dao.insertUpdateDB(student, dao.STUDENT_INSERT);
//		if (retval != 1) {
//			session.setAttribute("result", "등록에 실패했습니다.");
//		} else {
//			session.setAttribute("result", "insert");
//			session.setAttribute("student", student);
//
//		}
//		response.sendRedirect("result.jsp");
//	}
//
//}

//package com.test2;
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
// * Servlet implementation class BBSPostServlet
// */
//@WebServlet("/servletEx/BBSPostServlet")
//public class BBSPostServlet extends HttpServlet {
//	private static final long serialVersionUID = 1L;
//       
//    /**
//     * @see HttpServlet#HttpServlet()
//     */
//    public BBSPostServlet() {
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
//	public void doPost(HttpServletRequest request, HttpServletResponse response)
//			throws ServletException, IOException {
//		request.setCharacterEncoding("euc-kr");
//		String name = request.getParameter("name");
//		String title = request.getParameter("title");
//		String content = request.getParameter("content");
//		System.out.println(name + ", " + title + ", " + content);
//		HttpSession session = request.getSession();
//		session.setAttribute("name", name);
//		session.setAttribute("title", title);
//		session.setAttribute("content", content);
//		response.sendRedirect("BBSOutput.jsp");
//	}
//
//}

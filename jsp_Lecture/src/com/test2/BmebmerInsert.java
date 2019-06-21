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
// * Servlet implementation class BmebmerEx
// */
//@WebServlet("/login/BmebmerInsert")
//public class BmebmerInsert extends HttpServlet {
//	private static final long serialVersionUID = 1L;
//       
//    /**
//     * @see HttpServlet#HttpServlet()
//     */
//    public BmebmerInsert() {
//        super();
//        // TODO Auto-generated constructor stub
//    }
//
//	/**
//	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
//	 */
//	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		// TODO Auto-generated method stub
//		response.getWriter().append("Served at: ").append(request.getContextPath());
//	}
//
//	/**
//	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
//	 */
//	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		// TODO Auto-generated method stub
//		request.setCharacterEncoding("UTF-8");
//		String id = request.getParameter("id");
//		String pw = request.getParameter("pw");
//		String name = request.getParameter("name");
//		System.out.println(id + pw + name);
//		System.out.println("ex연결");
//		
//		BmemberDao dao = new BmemberDao();
//		int retVal = dao.insertMember(id, pw, name);
//		System.out.println("insertMember return : "+retVal);
//		HttpSession session = request.getSession();
//		if (retVal == 1) {
//			session.setAttribute("result", "아이디 등록을 완료하였습니다.");
//		} else {
//			session.setAttribute("result", "아이디 등록에 실패했습니다..");
//		}
//		response.sendRedirect("result.jsp");
//	}
//
//}

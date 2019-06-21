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
// * Servlet implementation class BmemberLogin
// */
//@WebServlet("/login/BmemberLogin")
//public class BmemberLogin extends HttpServlet {
//	private static final long serialVersionUID = 1L;
//       
//    /**
//     * @see HttpServlet#HttpServlet()
//     */
//    public BmemberLogin() {
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
//		// TODO Auto-generated method stub
//		request.setCharacterEncoding("UTF-8");
//		String id = request.getParameter("id");
//		String pw = request.getParameter("pw");
//		BmemberDao dao = new BmemberDao();
//		HttpSession session = request.getSession();
//		int retval = dao.loginCheck(id, pw);
//		if (retval == 1) {
//			session.setAttribute("result", "로그인에 성공하였습니다.");
//			session.setAttribute("uid", id);
//			session.setAttribute("upw", pw);
//			String name = dao.searchMember(id);
//			session.setAttribute("uname", name);
//			System.out.println("login sucess");
//		} else if (retval == 2) {
//			session.setAttribute("result", "잘못된 아이디 입니다.");
//			System.out.println("login fail");
//		} else if (retval == 3) {
//			session.setAttribute("result", "잘못된 비밀번호 입니다.");
//			System.out.println("login sucess");
//		}
//		response.sendRedirect("result.jsp");
//	}
//
//}

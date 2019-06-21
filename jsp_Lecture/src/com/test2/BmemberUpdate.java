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
// * Servlet implementation class BmemberUdate
// */
//@WebServlet("/login/BmemberUdate")
//public class BmemberUpdate extends HttpServlet {
//	private static final long serialVersionUID = 1L;
//       
//    /**
//     * @see HttpServlet#HttpServlet()
//     */
//    public BmemberUpdate() {
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
//	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		// TODO Auto-generated method stub
//		request.setCharacterEncoding("utf-8");
//		String id = request.getParameter("id");
//		String pw = request.getParameter("pw");
//		String name = request.getParameter("name");
//		HttpSession session = request.getSession();
//		BmemberDao dao = new BmemberDao();
//		int retval = dao.updateMember(id, pw, name);
//		if (retval == 1) {
//			session.setAttribute("result", "정보 수정이 완료되었습니다.");
//			session.setAttribute("upw", pw);
//			session.setAttribute("uname", name);
//		} else {
//			session.setAttribute("result", "정보 수정에 실패하였습니다..");
//
//		}
//		response.sendRedirect("result.jsp");
//	}
//
//}

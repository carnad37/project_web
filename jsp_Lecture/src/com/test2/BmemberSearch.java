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
// * Servlet implementation class BmemberSearch
// */
//@WebServlet("/login/BmemberSearch")
//public class BmemberSearch extends HttpServlet {
//	private static final long serialVersionUID = 1L;
//       
//    /**
//     * @see HttpServlet#HttpServlet()
//     */
//    public BmemberSearch() {
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
//		request.setCharacterEncoding("UTF-8");
//		String id = request.getParameter("id");
//		System.out.println("search id : " + id);
//		
//		BmemberDao dao = new BmemberDao();
//		String name = dao.searchMember(id);
//		System.out.println("searcMemberName return : "+name);
//		HttpSession session = request.getSession();
//		if (name != null) {
//			session.setAttribute("result", "�ش� ������ �̸��� " + name + "�Դϴ�.");
//		} else {
//			session.setAttribute("result", "��ϵ��� ���� ���̵� �Դϴ�.");
//		}
//		response.sendRedirect("result.jsp");
//	}
//
//}

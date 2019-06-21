//package com.test2;
//
//import java.io.IOException;
//import java.io.PrintWriter;
//import javax.servlet.ServletException;
//import javax.servlet.annotation.WebServlet;
//import javax.servlet.http.HttpServlet;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//
///**
// * Servlet implementation class AddServ
// */
//@WebServlet("/AddServ")
//public class AddServ extends HttpServlet {
//	private static final long serialVersionUID = 1L;
//       
//    /**
//     * @see HttpServlet#HttpServlet()
//     */
//    public AddServ() {
//        super();
//        // TODO Auto-generated constructor stub
//    }
//
//	/**
//	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
//	 */
//	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		// TODO Auto-generated method stub
//        String str1 = request.getParameter("NUM1");
//        String str2 = request.getParameter("NUM2");
//        int num1 = Integer.parseInt(str1);
//        int num2 = Integer.parseInt(str2);
//        int sum = num1 + num2;
//        response.setContentType("text/html;charset=euc-kr");
//        PrintWriter out = response.getWriter();
//        out.println("<HTML>");
//        out.println("<HEAD><TITLE>µ¡¼À ÇÁ·Î±×·¥ - °á°ú È­¸é</TITLE></HEAD>");
//        out.println("<BODY>");
//        out.printf("%d + %d = %d", num1, num2, sum);
//        out.println("</BODY>");
//        out.println("</HTML>");	
//     }
//
//	/**
//	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
//	 */
//	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		// TODO Auto-generated method stub
//		doGet(request, response);
//	}
//
//}

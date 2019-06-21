package com.servletEx;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class CalculatorSevlet
 */
@WebServlet("/examServlet/CalculatorSevlet")
public class CalculatorSevlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CalculatorSevlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		int num01 = Integer.parseInt(request.getParameter("num01"));
		int num02 = Integer.parseInt(request.getParameter("num02"));
		Calculator cal = new Calculator();
		int add = cal.add(num01, num02);
		int sub = cal.sub(num01, num02);
		int mul = cal.mul(num01, num02);
		double div = cal.div(num01, num02);
		
		HttpSession session = request.getSession();
		session.setAttribute("num01", num01);
		session.setAttribute("num02", num02);
		session.setAttribute("add", add);
		session.setAttribute("sub", sub);
		session.setAttribute("mul", mul);
		session.setAttribute("div", div);

		response.sendRedirect("numResult.jsp");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

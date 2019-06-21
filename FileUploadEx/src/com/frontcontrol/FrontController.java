package com.frontcontrol;

import java.io.File;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import com.command.Command;
import com.command.UploadCommand;

/**
 * Servlet implementation class FrontController
 */
@WebServlet("*.do")
@MultipartConfig(fileSizeThreshold = 1024*1024,
					maxFileSize=1024*1024*10,
					maxRequestSize=1024*1024*20)
public class FrontController extends HttpServlet {

	private static final long serialVersionUID = 1L;

	/**
     * @see HttpServlet#HttpServlet()
     */
    public FrontController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void actionDo(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		String uri = request.getRequestURI();
		String path = request.getContextPath();
		String action = uri.substring(path.length());
		String viewPage = "";
		if (action.equals("/upload.do")) {
		
			Command command = new UploadCommand();
			viewPage = command.execute(request, response);
		}
		response.sendRedirect(viewPage);
	
	
	}
	

    
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		actionDo(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		actionDo(request, response);
	}

}

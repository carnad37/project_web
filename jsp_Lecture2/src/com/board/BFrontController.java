package com.board;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.Dao.BoardDAO;
import com.command.BCommand;
import com.command.BContentCommand;
import com.command.BDeleteCommand;
import com.command.BListCommand;
import com.command.BReplyCommand;
import com.command.BRewriteCommand;
import com.command.BWriteCommand;

/**
 * Servlet implementation class BFrontController
 */
@WebServlet("*.do")
public class BFrontController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BFrontController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
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
	
	protected void actionDo(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		String viewPage = null;
		
		String uri = request.getRequestURI();
		String conPath = request.getContextPath();
		String com = uri.substring(conPath.length());
		System.out.println("com : " + com);
		
		if (com.equals("/write_view.do")) {
			System.out.println("call write.do");
			viewPage = "write.jsp";
//			viewPage = "write_view.jsp";
		} else if (com.equals("/list.do")) {
			System.out.println("call list.do");
			BCommand command = new BListCommand();
			command.execute(request, response);
			viewPage = "list.jsp";
		} else if (com.equals("/write.do")) {
			System.out.println("call write.do");
			BCommand command = new BWriteCommand();
			command.execute(request, response);
			viewPage = "list.do";
		} else if (com.equals("/content_view.do")) {
			System.out.println("call content_view.do");
			BCommand command = new BContentCommand();
			command.execute(request, response);
			viewPage = "content.jsp";
		} else if (com.equals("/reply.do")) {
			System.out.println("call reply.do");
			BCommand command = new BReplyCommand();
			command.execute(request, response);
			viewPage = "list.do";
		} else if (com.equals("/rewrite.do")) {
			System.out.println("call rewrite.do");
			BCommand command = new BRewriteCommand();
			command.execute(request, response);
			viewPage = "list.do";
		} else if (com.equals("/delete.do")) {
			System.out.println("call delete.do");
			BCommand command = new BDeleteCommand();
			command.execute(request, response);
			viewPage = "list.do";
		} else if (com.equals("/test.do")) {
			BoardDAO dao = new BoardDAO();
			dao.updateTest("test");
			viewPage = "list.do";
		} else if (com.equals("/commit.do")) {
			BoardDAO dao = new BoardDAO();
			dao.updateCommit();
			viewPage = "list.do";
		} else if (com.equals("/rollback.do")) {
			BoardDAO dao = new BoardDAO();
			dao.updateRollback();
			viewPage = "list.do";
		} else if (com.equals("/start.do")) {
			BoardDAO dao = new BoardDAO();
			dao.updateDBStart();
			viewPage = "list.do";
		} else if (com.equals("/qCommit.do")) {
			BoardDAO dao = new BoardDAO();
			dao.updateDBCommit();
			viewPage = "list.do";
		} else if (com.equals("/qRollback.do")) {
			BoardDAO dao = new BoardDAO();
			dao.updateDBRollback();
			viewPage = "list.do";
		}
		response.sendRedirect(viewPage);
	}
}

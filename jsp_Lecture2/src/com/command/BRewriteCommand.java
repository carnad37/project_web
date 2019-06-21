package com.command;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.Dao.BoardDAO;

public class BRewriteCommand implements BCommand {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int bId = Integer.parseInt(request.getParameter("bId"));
		String name = request.getParameter("name");
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		BoardDAO dao = new BoardDAO();
		int retval = dao.reWrite(bId, name, title, content);
		if (retval != 1) {
			System.out.println("title : " + title + ", update ERROR");
		}
	}
}

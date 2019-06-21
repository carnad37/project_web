package com.command;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.Dao.BoardDAO;
import com.Dto.BoardDTO;

public class BContentCommand implements BCommand {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stu
		HttpSession session = request.getSession();
		int bId = Integer.parseInt(request.getParameter("bId"));
		BoardDAO dao = new BoardDAO();
		BoardDTO dto = dao.callContent(bId);
		if (dto == null) {
			System.out.println("NO TARGET");
		} else {
			session.setAttribute("content", dto);
		}
	}

}

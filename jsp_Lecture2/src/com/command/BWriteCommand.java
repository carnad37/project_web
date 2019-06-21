package com.command;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.Dao.BoardDAO;
import com.Dto.BoardDTO;

public class BWriteCommand implements BCommand {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name = request.getParameter("name");
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		BoardDTO dto = new BoardDTO();
		BoardDAO dao = new BoardDAO();
		dto.setbName(name);
		dto.setbTitle(title);
		dto.setbContent(content);
		dto.setbGroup(1);
		int retval = dao.write(dto);
		if (retval != 1) {
			System.out.println("title : " + title + ", update ERROR");
		}
	}

}

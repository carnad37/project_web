package com.command;

import java.io.File;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

public class UploadCommand implements Command {
	private static final String SAVE_DIR = "uploadFiles";

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String appPath = request.getServletContext().getRealPath("");
		String savePath = appPath + SAVE_DIR;
		File fileSaveDir = new File(savePath);
		if (!fileSaveDir.exists()) {
			fileSaveDir.mkdirs();
		}
		
		for (Part part : request.getParts()) {
			String fileName = extractFileName(part);
			System.out.println("fileName1 : " + fileName);
			fileName = new File(fileName).getName();
			System.out.println("fileName2 : " + fileName);
			part.write(savePath + File.separator + fileName);
		}
		// TODO Auto-generated method stub
		return null;
	}
	
	private String extractFileName(Part part) {
		String contentDisp = part.getHeader("content-disposition");
		System.out.println("content-disposition : " + contentDisp);
		String[] items = contentDisp.split(";");
		for (String s : items) {
			System.out.println("s : "+s);
			if (s.trim().startsWith("filename")) {
				return s.substring(s.indexOf("=") + 2, s.length()-1);
			}
		}
		return null;
	}

}

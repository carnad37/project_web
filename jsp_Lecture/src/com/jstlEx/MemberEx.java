package com.jstlEx;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class MemberEx
 */
@WebServlet("/jstl/MemberEx")
public class MemberEx extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MemberEx() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		// TODO Auto-generated method stub
//		List<MemberDTO> mdtoArrayList = new ArrayList<MemberDTO>();
//		Map<String,String> mdtosStringMap = new HashMap<String, String>();
//		Map<String,MemberDTO> mdtosObjectMap = new HashMap<String, MemberDTO>();
//		HttpSession session = request.getSession();
//		
//		MemberDTO mdto = new MemberDTO();
//		mdto.setName("mouse");
//		mdto.setId("monitor");
//		mdto.setPw("cup");
//		mdtoArrayList.add(mdto);
//		mdtosStringMap.put("monitor", "cup");
//		mdtosObjectMap.put("moniter", mdto);
//		
//		MemberDTO mdto1 = new MemberDTO();
//		mdto1.setName("mouse");
//		mdto1.setId("orange");
//		mdto1.setPw("desk");
//		mdtoArrayList.add(mdto1);
//		mdtosStringMap.put("orange", "desk");
//		mdtosObjectMap.put("orange", mdto1);
//		
//		String[] arr = {"apple", "orange", "desk"};
//		
//		session.setAttribute("mdtosArr", arr);
//		session.setAttribute("mdtosList", mdtoArrayList);
//		session.setAttribute("mdtosStringMap", mdtosStringMap);
//		session.setAttribute("mdtosObjectMap", mdtosObjectMap);
//		session.setAttribute("mdto", mdto1);
//		
//		response.sendRedirect("jstl_output.jsp");
		ArrayList<MemberDTO> mdtoArrayList= new ArrayList <MemberDTO>();
		Map<String, String> mdtoStringMap= new HashMap<String, String>();
		Map<String, MemberDTO> mdtoObjMap= new HashMap<String, MemberDTO>();
		HttpSession httpSession = request.getSession();
		
		MemberDTO mdto = new MemberDTO();
		mdto.setName("mouse");
		mdto.setId("monitor");
		mdto.setPw("cup");
		mdtoArrayList.add(mdto);
		mdtoStringMap.put("monitor", "cup");
		mdtoObjMap.put("monitor", mdto);
		
		MemberDTO mdto1 = new MemberDTO();
		mdto1.setName("apple");
		mdto1.setId("orange");
		mdto1.setPw("desk");
		mdtoArrayList.add(mdto1);
		mdtoStringMap.put("orange", "desk");
		mdtoObjMap.put("orange", mdto1);
		
		String[] arr = {"apple","orange","desk"};

		httpSession.setAttribute("mdtosArr", arr);
		httpSession.setAttribute("mdtosList", mdtoArrayList);
		httpSession.setAttribute("mdtosStringMap", mdtoStringMap);
		httpSession.setAttribute("mdtosObjectMap", mdtoObjMap);	
		httpSession.setAttribute("mdto", mdto1);
		
		response.sendRedirect("jstl_output.jsp");

	}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

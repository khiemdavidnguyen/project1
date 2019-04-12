package com.java.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.java.dao.StaffDao;
import com.java.dao.StaffDaoImpl;
import com.java.models.Staff;
import com.java.util.RequestHelper;

public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("WebPages/html/login.html").forward(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		System.out.println("In the doPOST method in Login Servlet");
		
		StaffDao s = new StaffDaoImpl();
		Staff staffMember = s.getStaffByUserName(username);  
		if( staffMember == null || !password.equals( staffMember.getUserPassword() ) ) 
		{
		
			response.sendRedirect("login");		
			return;
		}
		
	
		HttpSession session = request.getSession();
		session.setAttribute("username", username); 		
		response.sendRedirect( RequestHelper.getLoginHomepageRedirect(staffMember) );
	
	}


}

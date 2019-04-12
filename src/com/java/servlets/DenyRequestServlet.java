package com.java.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.java.dao.ReimbursementDao;
import com.java.dao.ReimbursementDaoImpl;

public class DenyRequestServlet extends HttpServlet{
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(false);
		if(session == null) {
			response.sendRedirect("login");
			return;
		}
		
		ReimbursementDao rd = new ReimbursementDaoImpl();
		String sid=request.getParameter("id");  
        int id=Integer.parseInt(sid);  
        rd.denyRequest(id);  
        response.sendRedirect("manager-home");  
	}
}

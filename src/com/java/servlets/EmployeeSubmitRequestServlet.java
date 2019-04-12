package com.java.servlets;
import java.sql.Timestamp;
import java.text.DateFormat;  
import java.text.SimpleDateFormat;  
import java.util.Date;  
import java.util.Calendar;  
import java.util.Date;


import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.java.dao.ReimbursementDao;
import com.java.dao.ReimbursementDaoImpl;
import com.java.dao.StaffDao;
import com.java.dao.StaffDaoImpl;
import com.java.models.Reimbursement;
import com.java.models.Staff;

public class EmployeeSubmitRequestServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		if(session == null)
			response.sendRedirect("login");
		else
			request.getRequestDispatcher("WebPages/html/employee-submit-request.html").forward(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		if(session == null)
			response.sendRedirect("login");
		else
		{
            Date date = Calendar.getInstance().getTime();  
            DateFormat dateFormat = new SimpleDateFormat("yyyy-mm-dd hh:mm:ss");  
            String strDate = dateFormat.format(date);  
	        
			
			Double amount = Double.parseDouble( request.getParameter("amount") );
			String description = request.getParameter("description");
			String receipt = null;
			Integer type = Integer.parseInt(request.getParameter("type"));
			
			
			
			StaffDao sd = new StaffDaoImpl();
			Staff s = sd.getStaffByUserName( (String) session.getAttribute("username") );
			int staffId = s.getUserId();
												
			ReimbursementDao rd = new ReimbursementDaoImpl();
			rd.createRequest( new Reimbursement (0, amount, strDate,  null , description, receipt, staffId, 0, 1, type, null, null ));
				response.sendRedirect("success");
		}

}
}



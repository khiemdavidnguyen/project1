package com.java.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.java.dao.ReimbursementDao;
import com.java.dao.ReimbursementDaoImpl;
import com.java.dao.StaffDao;
import com.java.dao.StaffDaoImpl;

public class AJAXEmployeeNotPendingRequestServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	System.out.println("in the AJAXemployeeViewPendingRequest");
	HttpSession session = request.getSession(false);
	if(session == null) {
		response.sendRedirect("login");
		return;
	}
	
	ReimbursementDao rd = new ReimbursementDaoImpl();
	StaffDao sd = new StaffDaoImpl();
	ObjectMapper om = new ObjectMapper();
	PrintWriter pw = response.getWriter();

	
	String username = (String) session.getAttribute("username");
	int staff_Id = sd.getStaffByUserName(username).getUserId();
	
	String queryPendingRequests ="select * from ERS_REIMBURSEMENT a, \r\n" + 
			"ERS_REIMBURSEMENT_STATUS b, ERS_REIMBURSEMENT_TYPE c \r\n" + 
			"where not a.REIMB_STATUS_ID =1 and a.REIMB_STATUS_ID = B.REIMB_STATUS_ID and \r\n" + 
			"a.REIMB_TYPE_ID = c.REIMB_TYPE_ID and REIMB_AUTHOR =" + staff_Id + "order by a.REIMB_ID";
	List<Object> list = rd.listReimbursementsNotPendingStatus(queryPendingRequests);
	String data = om.writeValueAsString(list);
	pw.print(data);

}
	
}

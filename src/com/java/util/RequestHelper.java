package com.java.util;

import com.java.models.Staff;

public class RequestHelper {

	public static String getLoginHomepageRedirect(Staff staff)
	{
		switch (staff.getUserRoleId())
		{
		case 1:						
			
			return "employee-home"; 
		case 2:					
			
			return "manager-home";
		default:
			return "login"; 
		}			
	} 
	
}


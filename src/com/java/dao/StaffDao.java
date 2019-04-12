package com.java.dao;

import java.util.List;

import com.java.models.Staff;

public interface StaffDao {
	public List<Staff> listStaffMembers(String sql);
	public Staff getStaffByUserName(String userName);
	
	
	

}

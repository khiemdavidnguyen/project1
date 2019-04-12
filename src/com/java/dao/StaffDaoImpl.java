package com.java.dao;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.io.IOException;
import com.java.models.ReimbursementPending;
import com.java.models.Staff;
import com.java.util.ConnectionUtil;

public class StaffDaoImpl implements StaffDao {
	public List<Staff> listStaffMembers(String sql) {
		return null;
	}
	@Override
	public Staff getStaffByUserName(String username) {
		String sql = "SELECT * FROM ERS_USERS WHERE ERS_USERNAME = ?";
		ResultSet rs = null;
		Staff staffMember = null;
		try (Connection con = ConnectionUtil.getConnection();
				PreparedStatement ps = con.prepareStatement(sql); )
		{
			ps.setString(1, username);
			rs = ps.executeQuery();
			
			if(rs.next())
			{
				int userId = rs.getInt("ERS_USERS_ID");
				String userPassword= rs.getString("ERS_PASSWORD");
				String userFirstName = rs.getString("USER_FIRST_NAME");
				String userLastName = rs.getString("USER_LAST_NAME");
				String userEmail = rs.getString("USER_EMAIL");
				int userRoleId = rs.getInt("USER_ROLE_ID");
		
				staffMember = new Staff(userId, username, userPassword, userFirstName, userLastName, userEmail, userRoleId);
				
			}
				
			} catch (SQLException | IOException e) {
				e.printStackTrace();
				System.out.println("there was an exception");
			return null;
			}
		return staffMember;
	}

	
}

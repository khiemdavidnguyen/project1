package com.java.dao;


import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.java.models.Reimbursement;
import com.java.models.ReimbursementPending;
import com.java.util.ConnectionUtil;

public class ReimbursementDaoImpl implements ReimbursementDao{
	@Override
	public int createRequest(Reimbursement r)
	{
		String sql = "INSERT INTO ERS_REIMBURSEMENT " +
					"VALUES(REIMBIDGENERATOR.nextval, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
		int numRowsChanged = 0;
		try(Connection con = ConnectionUtil.getConnection(); 
				PreparedStatement ps = con.prepareStatement(sql); )
		{
			System.out.println("preparing statement!");
			ps.setDouble(1, r.getReimbAmount());
			ps.setString(2, r.getSubmitDate());
			ps.setString(3, null);
			ps.setString(4, r.getDescription());
			ps.setString(5, null);
			ps.setInt(6, r.getAuthorId());
			ps.setInt(7, 0);
			ps.setInt(8, 1);
			ps.setInt(9, r.getTypeId());
			System.out.println("finishing statement!");
			
			numRowsChanged = ps.executeUpdate();
			
		} catch (SQLException | IOException e) {
			e.printStackTrace();
			System.out.println("there was an exception");
		}
		return numRowsChanged;
	}
	@Override
	public List<Object> listReimbursements(String sql) {
		List<Object> list = new ArrayList<>(); 
		ResultSet rs = null;
		
		try(Connection con = ConnectionUtil.getConnection();
				PreparedStatement ps = con.prepareStatement(sql); )
		{
			rs = ps.executeQuery();
	
			while(rs.next())
			{		
				int reimbId = rs.getInt("REIMB_ID");
				double reimbAmount = rs.getDouble("REIMB_AMOUNT");
				String submitDate = rs.getString("REIMB_SUBMITTED");
				String resolvedDate = rs.getString("REIMB_RESOLVED");
				String description = rs.getString("REIMB_DESCRIPTION");
				String receipt = rs.getString("REIMB_RECEIPT");
				int authorId = rs.getInt("REIMB_AUTHOR");
				int resolverId = rs.getInt("REIMB_RESOLVER");
				int statusId = rs.getInt("REIMB_STATUS_ID");
				int typeId = rs.getInt("REIMB_TYPE_ID");
				String type = rs.getString("REIMB_TYPE");
				String status = rs.getString("REIMB_STATUS");
				
				list.add(new Reimbursement(reimbId, reimbAmount, submitDate, resolvedDate, description, receipt, authorId, resolverId, statusId, typeId, type, status));
			}
			
		} catch (SQLException | IOException e) {
			e.printStackTrace();
			System.out.println("there was an exception");
		} finally {
			if(rs != null)
				try {
					rs.close();
				} catch (SQLException e) {
					e.printStackTrace();
					System.out.println("there was an exception");
				}
		} 
		
		return list;
	}
	@Override
	public List<Object> listReimbursementsPendingStatus(String sql) {
		List<Object> list = new ArrayList<>(); 
		ResultSet rs = null;
		
		try(Connection con = ConnectionUtil.getConnection();
				PreparedStatement ps = con.prepareStatement(sql); )
		{
			rs = ps.executeQuery();
	
			while(rs.next())
			{		
				int reimbId = rs.getInt("REIMB_ID");
				double reimbAmount = rs.getDouble("REIMB_AMOUNT");
				String submitDate = rs.getString("REIMB_SUBMITTED");
				String resolvedDate = rs.getString("REIMB_RESOLVED");
				String description = rs.getString("REIMB_DESCRIPTION");
				String receipt = rs.getString("REIMB_RECEIPT");
				int authorId = rs.getInt("REIMB_AUTHOR");
				int resolverId = rs.getInt("REIMB_RESOLVER");
				int statusId = rs.getInt("REIMB_STATUS_ID");
				int typeId = rs.getInt("REIMB_TYPE_ID");
				String type = rs.getString("REIMB_TYPE");
				String status = rs.getString("REIMB_STATUS");
				
				list.add(new ReimbursementPending(reimbId, reimbAmount, submitDate, resolvedDate, description, receipt, authorId, resolverId, statusId, typeId, type, status));
			}
			
		} catch (SQLException | IOException e) {
			e.printStackTrace();
			System.out.println("there was an exception");
		} finally {
			if(rs != null)
				try {
					rs.close();
				} catch (SQLException e) {
					e.printStackTrace();
					System.out.println("there was an exception");
				}
		} 
		
		return list;
	}
	@Override
	public List<Object> listReimbursementsNotPendingStatus(String sql) {
		List<Object> list1 = new ArrayList<>(); 
		ResultSet rs1 = null;
		
		try(Connection con = ConnectionUtil.getConnection();
				PreparedStatement ps = con.prepareStatement(sql); )
		{
			rs1 = ps.executeQuery();
	
			while(rs1.next())
			{		
				int reimbId = rs1.getInt("REIMB_ID");
				double reimbAmount = rs1.getDouble("REIMB_AMOUNT");
				String submitDate = rs1.getString("REIMB_SUBMITTED");
				String resolvedDate = rs1.getString("REIMB_RESOLVED");
				String description = rs1.getString("REIMB_DESCRIPTION");
				String receipt = rs1.getString("REIMB_RECEIPT");
				int authorId = rs1.getInt("REIMB_AUTHOR");
				int resolverId = rs1.getInt("REIMB_RESOLVER");
				int statusId = rs1.getInt("REIMB_STATUS_ID");
				int typeId = rs1.getInt("REIMB_TYPE_ID");
				String type = rs1.getString("REIMB_TYPE");
				String status = rs1.getString("REIMB_STATUS");
				
				list1.add(new ReimbursementPending(reimbId, reimbAmount, submitDate, resolvedDate, description, receipt, authorId, resolverId, statusId, typeId, type, status));
			}
			
		} catch (SQLException | IOException e) {
			e.printStackTrace();
			System.out.println("there was an exception");
		} finally {
			if(rs1 != null)
				try {
					rs1.close();
				} catch (SQLException e) {
					e.printStackTrace();
					System.out.println("there was an exception");
				}
		} 
		
		return list1;
	}
	@Override
	public void approveRequest(int r) {  
		String sql = "UPDATE ERS_REIMBURSEMENT SET REIMB_STATUS_ID = 2 WHERE REIMB_ID = ?";
		
		
		try( Connection con = ConnectionUtil.getConnection(); 
				PreparedStatement ps = con.prepareStatement(sql); )
		{	
		ps.setLong(1, r);	
		ps.executeUpdate();
			
		} catch (SQLException | IOException e) {
			e.printStackTrace();
			System.out.println("There was an exeption at approveRequest");
		}
		
		
	}
	@Override
	public void denyRequest(int r) {  
		String sql = "UPDATE ERS_REIMBURSEMENT SET REIMB_STATUS_ID = 3 WHERE REIMB_ID = ?";
		
		
		try( Connection con = ConnectionUtil.getConnection(); 
				PreparedStatement ps = con.prepareStatement(sql); )
		{	
		ps.setLong(1, r);	
		ps.executeUpdate();
			
		} catch (SQLException | IOException e) {
			e.printStackTrace();
			System.out.println("There was an exception at denyRequest");
		}
		
		
	}
	@Override
	public void openRequest(int r) {  
		String sql = "UPDATE ERS_REIMBURSEMENT SET REIMB_STATUS_ID = 1 WHERE REIMB_ID = ?";
		
		
		try( Connection con = ConnectionUtil.getConnection(); 
				PreparedStatement ps = con.prepareStatement(sql); )
		{	
		ps.setLong(1, r);	
		ps.executeUpdate();
			
		} catch (SQLException | IOException e) {
			e.printStackTrace();
			System.out.println("There was an exception at openRequest");
		}
		
		
	}

}

package com.java.dao;

import java.util.List;

import com.java.models.Reimbursement;

public interface ReimbursementDao {
	public int createRequest(Reimbursement r);
	public List<Object> listReimbursements(String sql);
	public List<Object> listReimbursementsPendingStatus(String sql);
	public List<Object> listReimbursementsNotPendingStatus(String sql);
	public void approveRequest(int reimbId);
	public void denyRequest(int reimbId);
	public void openRequest(int id);
}

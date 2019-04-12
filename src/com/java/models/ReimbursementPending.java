package com.java.models;

import java.sql.Timestamp;

import com.java.models.ReimbursementPending;

public class ReimbursementPending {
	private int reimbId;
	private double reimbAmount;
	private String submitDate; 
	private String resolvedDate;
	private String description;  
	private String receipt;   
	private int authorId; 
	private int resolverId; 
	private int statusId; 
	private int typeId; 
	private String type; 
	private String status; 

	public ReimbursementPending(int reimbId, double reimbAmount, String submitDate, String resolvedDate, String description, String receipt, int authorId, int resolverId, int statusId, int typeId, String type, String status  ) {
		super();
		this.reimbId = reimbId;
		this.reimbAmount = reimbAmount;
		this.submitDate = submitDate;
		this.resolvedDate = resolvedDate;
		this.description = description;
		this.receipt = receipt;
		this.authorId = authorId;
		this.resolverId = resolverId;
		this.authorId = authorId;
		this.statusId = statusId;
		this.typeId = typeId;
		this.type = type;
		this.status = status;
	}
	public int getReimbId() {
		return reimbId;
	}

	public void setReimbId(int reimbId) {
		this.reimbId = reimbId;
	}

	public double getReimbAmount() {
		return reimbAmount;
	}

	public void setReimbAmount(double reimbAmount) {
		this.reimbAmount = reimbAmount;
	}

	public String getSubmitDate() {
		return submitDate;
	}

	public void setSubmitDate(String submitDate) {
		this.submitDate = submitDate;
	}

	public String getResolvedDate() {
		return resolvedDate;
	}

	public void setResolvedDate(String resolvedDate) {
		this.resolvedDate = resolvedDate;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getReceipt() {
		return receipt;
	}

	public void setReceipt(String receipt) {
		this.receipt = receipt;
	}

	public int getAuthorId() {
		return authorId;
	}

	public void setAuthorId(int authorId) {
		this.authorId = authorId;
	}

	public int getResolverId() {
		return resolverId;
	}

	public void setResolverId(int resolverId) {
		this.resolverId = resolverId;
	}

	public int getStatusId() {
		return statusId;
	}

	public void setStatusId(int statusId) {
		this.statusId = statusId;
	}

	public int getTypeId() {
		return typeId;
	}

	public void setTypeId(int typeId) {
		this.typeId = typeId;
	}
	
	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getStatus() {
		return status;
	}

	public void setstatus(String status) {
		this.status = status;
	}

	

}

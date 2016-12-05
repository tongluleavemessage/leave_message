package com.tonglukuaijian.commerce.dto;

import java.util.Date;

public class LeaveMessageAssignRecordDto {
	private Long id;
	private String projectId;
	private String projectName;
	private String customerName;
	private Integer status;
	private Date leaveMessageTime;
	/**
	 * 项目负责人姓名
	 */
	private String projectPrincipalName;
	/**
	 * 负责人手机号
	 */
	private String principalPhoneNum;
	/**
	 * 操作姓名
	 */
	private String operatorName;
	/**
	 * 操作角色名称
	 */
	private String operatorRoleName;

	/**
	 * 分派给的用户名称
	 */
	private String assignToUserName;
	private Date assignTime;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getProjectId() {
		return projectId;
	}

	public void setProjectId(String projectId) {
		this.projectId = projectId;
	}

	public String getProjectName() {
		return projectName;
	}

	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public Date getLeaveMessageTime() {
		return leaveMessageTime;
	}

	public void setLeaveMessageTime(Date leaveMessageTime) {
		this.leaveMessageTime = leaveMessageTime;
	}

	public String getProjectPrincipalName() {
		return projectPrincipalName;
	}

	public void setProjectPrincipalName(String projectPrincipalName) {
		this.projectPrincipalName = projectPrincipalName;
	}

	public String getPrincipalPhoneNum() {
		return principalPhoneNum;
	}

	public void setPrincipalPhoneNum(String principalPhoneNum) {
		this.principalPhoneNum = principalPhoneNum;
	}

	public String getOperatorName() {
		return operatorName;
	}

	public void setOperatorName(String operatorName) {
		this.operatorName = operatorName;
	}

	public String getOperatorRoleName() {
		return operatorRoleName;
	}

	public void setOperatorRoleName(String operatorRoleName) {
		this.operatorRoleName = operatorRoleName;
	}

	public String getAssignToUserName() {
		return assignToUserName;
	}

	public void setAssignToUserName(String assignToUserName) {
		this.assignToUserName = assignToUserName;
	}

	public Date getAssignTime() {
		return assignTime;
	}

	public void setAssignTime(Date assignTime) {
		this.assignTime = assignTime;
	}

}

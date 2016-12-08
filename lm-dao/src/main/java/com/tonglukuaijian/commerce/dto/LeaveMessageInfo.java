package com.tonglukuaijian.commerce.dto;

import java.util.Date;

public class LeaveMessageInfo {
	private Long id;
	private String projectId;
	private String projectName;
	private String projectPrincipalUserName;
	private String principalPhoneNum;
	private String customerName;
	private String customerPhone;
	private String content;
	private Integer status;
	private Date createdTime;
	private Long leaveMessagePrincipalUserId;

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

	public String getProjectPrincipalUserName() {
		return projectPrincipalUserName;
	}

	public void setProjectPrincipalUserName(String projectPrincipalUserName) {
		this.projectPrincipalUserName = projectPrincipalUserName;
	}

	public String getPrincipalPhoneNum() {
		return principalPhoneNum;
	}

	public void setPrincipalPhoneNum(String principalPhoneNum) {
		this.principalPhoneNum = principalPhoneNum;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public String getCustomerPhone() {
		return customerPhone;
	}

	public void setCustomerPhone(String customerPhone) {
		this.customerPhone = customerPhone;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public Date getCreatedTime() {
		return createdTime;
	}

	public void setCreatedTime(Date createdTime) {
		this.createdTime = createdTime;
	}

	public Long getLeaveMessagePrincipalUserId() {
		return leaveMessagePrincipalUserId;
	}

	public void setLeaveMessagePrincipalUserId(Long leaveMessagePrincipalUserId) {
		this.leaveMessagePrincipalUserId = leaveMessagePrincipalUserId;
	}

}

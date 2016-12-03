package com.tonglukuaijian.commerce.bean;

import java.util.Date;

/**
 * 留言分派
 *
 * @author Lhy 2016年11月21日上午9:35:49
 */
public class LeaveMessageAssignRecord {
	private Long id;

	private String operatorUserPhone;
	/**
	 * 操作员名称
	 */
	private String operatorUserName;

	/**
	 * 操作员角色名称
	 */
	private String operatorRoleName;

	/**
	 * 留言ID
	 */
	private Long leaveMessageId;

	/**
	 * 留言状态
	 */
	private Integer leaveMessageStatus;
	/**
	 * 留言负责人手机号
	 */
	private String assignUserPhoneNum;
	/**
	 * 留言负责人账号
	 */
	private String assignUserAccountNumber;

	/**
	 * 留言负责人名称
	 */
	private String assignUserName;
	/**
	 * 留言负责人角色
	 */
	private String assignRoleName;

	/**
	 * 创建时间
	 */
	private Date createdTime;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getOperatorUserPhone() {
		return operatorUserPhone;
	}

	public void setOperatorUserPhone(String operatorUserPhone) {
		this.operatorUserPhone = operatorUserPhone;
	}

	public Long getLeaveMessageId() {
		return leaveMessageId;
	}

	public void setLeaveMessageId(Long leaveMessageId) {
		this.leaveMessageId = leaveMessageId;
	}

	public Date getCreatedTime() {
		return createdTime;
	}

	public void setCreatedTime(Date createdTime) {
		this.createdTime = createdTime;
	}

	public String getOperatorUserName() {
		return operatorUserName;
	}

	public void setOperatorUserName(String operatorUserName) {
		this.operatorUserName = operatorUserName;
	}

	public String getOperatorRoleName() {
		return operatorRoleName;
	}

	public void setOperatorRoleName(String operatorRoleName) {
		this.operatorRoleName = operatorRoleName;
	}

	public Integer getLeaveMessageStatus() {
		return leaveMessageStatus;
	}

	public void setLeaveMessageStatus(Integer leaveMessageStatus) {
		this.leaveMessageStatus = leaveMessageStatus;
	}

	public String getAssignUserName() {
		return assignUserName;
	}

	public void setAssignUserName(String assignUserName) {
		this.assignUserName = assignUserName;
	}

	public String getAssignUserAccountNumber() {
		return assignUserAccountNumber;
	}

	public void setAssignUserAccountNumber(String assignUserAccountNumber) {
		this.assignUserAccountNumber = assignUserAccountNumber;
	}

	public String getAssignRoleName() {
		return assignRoleName;
	}

	public void setAssignRoleName(String assignRoleName) {
		this.assignRoleName = assignRoleName;
	}

	public String getAssignUserPhoneNum() {
		return assignUserPhoneNum;
	}

	public void setAssignUserPhoneNum(String assignUserPhoneNum) {
		this.assignUserPhoneNum = assignUserPhoneNum;
	}

}

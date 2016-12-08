package com.tonglukuaijian.commerce.dto;

import java.util.Date;

public class ProjectDto {
	private Long id;

	/**
	 * 部门名称
	 */
	private String departmentName;
	/**
	 * 部长账号
	 */
	private String ministerNumber;
	/**
	 * 部长名称
	 */
	private String ministerName;
	/**
	 * 群总账号
	 */
	private String groupNumber;
	/**
	 * 群总名称
	 */
	private String groupName;
	private String projectId;
	private String projectName;
	/**
	 * 角色名称
	 */
	private String roleName;
	/**
	 * 账号
	 */
	private String accountNumber;
	/**
	 * 用户姓名
	 */
	private String userName;
	/**
	 * 手机号
	 */
	private String phoneNum;
	private Date createdTime;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDepartmentName() {
		return departmentName;
	}

	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
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

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	public String getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPhoneNum() {
		return phoneNum;
	}

	public void setPhoneNum(String phoneNum) {
		this.phoneNum = phoneNum;
	}

	public Date getCreatedTime() {
		return createdTime;
	}

	public void setCreatedTime(Date createdTime) {
		this.createdTime = createdTime;
	}

	public String getMinisterNumber() {
		return ministerNumber;
	}

	public void setMinisterNumber(String ministerNumber) {
		this.ministerNumber = ministerNumber;
	}

	public String getMinisterName() {
		return ministerName;
	}

	public void setMinisterName(String ministerName) {
		this.ministerName = ministerName;
	}

	public String getGroupNumber() {
		return groupNumber;
	}

	public void setGroupNumber(String groupNumber) {
		this.groupNumber = groupNumber;
	}

	public String getGroupName() {
		return groupName;
	}

	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}

}

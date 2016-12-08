package com.tonglukuaijian.commerce.dto;

import java.util.Date;

public class UserDto {
	private Long id;
	/**
	 * 账号
	 */
	private String accountNumber;

	/**
	 * 姓名
	 */
	private String name;
	/**
	 * 手机号
	 */
	private String phoneNum;
	/**
	 * 部门
	 */
	private Long departmentId;

	/**
	 * 部门名称
	 */
	private String departmentName;
	/**
	 * 角色
	 */
	private Long roleId;
	/**
	 * 角色名称
	 */
	private String roleName;

	private Integer status;

	private Integer using;

	// 登录时间
	private Date loginTime;
	private Date createdTime;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getAccountNumber() {
		return accountNumber;
	}
	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPhoneNum() {
		return phoneNum;
	}
	public void setPhoneNum(String phoneNum) {
		this.phoneNum = phoneNum;
	}
	public Long getDepartmentId() {
		return departmentId;
	}
	public void setDepartmentId(Long departmentId) {
		this.departmentId = departmentId;
	}
	public String getDepartmentName() {
		return departmentName;
	}
	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}
	public Long getRoleId() {
		return roleId;
	}
	public void setRoleId(Long roleId) {
		this.roleId = roleId;
	}
	public String getRoleName() {
		return roleName;
	}
	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	public Integer getUsing() {
		return using;
	}
	public void setUsing(Integer using) {
		this.using = using;
	}
	public Date getLoginTime() {
		return loginTime;
	}
	public void setLoginTime(Date loginTime) {
		this.loginTime = loginTime;
	}
	public Date getCreatedTime() {
		return createdTime;
	}
	public void setCreatedTime(Date createdTime) {
		this.createdTime = createdTime;
	}
	
	

}

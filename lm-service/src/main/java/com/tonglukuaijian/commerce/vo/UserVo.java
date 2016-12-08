package com.tonglukuaijian.commerce.vo;

import javax.validation.constraints.NotNull;

public class UserVo {
	/**
	 * 账号
	 */
	@NotNull(message = "账号不能为空")
	private String accountNumber;
	/**
	 * 密码
	 */
	@NotNull(message = "密码不能为空")
	private String password;
	/**
	 * 姓名
	 */
	@NotNull(message = "姓名不能为空")
	private String name;
	/**
	 * 手机号
	 */
	@NotNull(message = "手机号不能为空")
	private String phoneNumber;
	/**
	 * 部门
	 */
	@NotNull(message = "部门不能为空")
	private Long departmentId;
	/**
	 * 角色
	 */
	@NotNull(message = "角色不能为空")
	private Long roleId;

	@NotNull(message = "请选择状态")
	private Integer status;

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

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public Long getDepartmentId() {
		return departmentId;
	}

	public void setDepartmentId(Long departmentId) {
		this.departmentId = departmentId;
	}

	public Long getRoleId() {
		return roleId;
	}

	public void setRoleId(Long roleId) {
		this.roleId = roleId;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

}

package com.tonglukuaijian.commerce.vo;

import javax.validation.constraints.NotNull;

public class UpdateUserVo {

	/**
	 * 手机号
	 */
	private String phoneNumber;
	/**
	 * 部门
	 */
	private Long departmentId;
	/**
	 * 角色
	 */
	private Long roleId;

	private Integer status;
	/**
	 * 密码
	 */
	private String password;

	@NotNull(message = "未指定用户")
	private Long userId;

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

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}

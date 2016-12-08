package com.tonglukuaijian.commerce.vo;

import javax.validation.constraints.NotNull;

public class UpdateRoleVo {
	private String name;
	/**
	 * 说明
	 */
	private String explain;
	private Integer status;
	@NotNull(message = "未指定角色")
	private Long roleId;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getExplain() {
		return explain;
	}

	public void setExplain(String explain) {
		this.explain = explain;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public Long getRoleId() {
		return roleId;
	}

	public void setRoleId(Long roleId) {
		this.roleId = roleId;
	}

}

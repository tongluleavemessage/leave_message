package com.tonglukuaijian.commerce.vo;

import javax.validation.constraints.NotNull;

/**
 * 角色
 *
 * @author Lhy 2016年11月21日下午6:53:40
 */
public class RoleVo {
	/**
	 * 角色名称
	 */
	@NotNull(message = "名称不能为空")
	private String name;
	/**
	 * 角色说明
	 */
	private String explain;
	@NotNull(message = "状态不能为空")
	private Integer status;

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

}

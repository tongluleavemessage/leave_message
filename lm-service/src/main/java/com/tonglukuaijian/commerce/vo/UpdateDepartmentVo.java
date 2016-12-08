package com.tonglukuaijian.commerce.vo;

import javax.validation.constraints.NotNull;

/**
 * 部门修改
 *
 * @author Lhy 2016年12月5日下午5:01:53
 */
public class UpdateDepartmentVo {
	private String name;
	private Integer status;
	@NotNull(message = "未指定部门")
	private Long departmentId;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public Long getDepartmentId() {
		return departmentId;
	}

	public void setDepartmentId(Long departmentId) {
		this.departmentId = departmentId;
	}

}

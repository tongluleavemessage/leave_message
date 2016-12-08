package com.tonglukuaijian.commerce.vo;

import javax.validation.constraints.NotNull;

/**
 * 部门
 *
 * @author Lhy 2016年11月22日下午2:33:28
 */
public class DepartmentVo {
	@NotNull(message = "名称不能为空")
	private String name;
	@NotNull(message = "请选择状态")
	private Integer status;

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

}

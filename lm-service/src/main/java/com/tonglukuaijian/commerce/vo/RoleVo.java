package com.tonglukuaijian.commerce.vo;

/**
 * 角色
 *
 * @author Lhy 2016年11月21日下午6:53:40
 */
public class RoleVo {
	/**
	 * 角色名称
	 */
	private String name;
	/**
	 * 角色说明
	 */
	private String explain;
	private Integer status;
	
	private Long id;

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

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	
}

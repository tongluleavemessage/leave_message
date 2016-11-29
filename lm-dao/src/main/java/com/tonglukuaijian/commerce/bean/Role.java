package com.tonglukuaijian.commerce.bean;

import java.util.Date;

/**
 * 角色
 *
 * @author Lhy 2016年11月18日下午2:23:27
 */
public class Role {
	private Long id;
	/**
	 * 名称
	 */
	private String name;
	/**
	 * 说明
	 */
	private String explain;
	/**
	 * 状态
	 */
	private Integer status;
	private Date createdTime;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

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

	public Date getCreatedTime() {
		return createdTime;
	}

	public void setCreatedTime(Date createdTime) {
		this.createdTime = createdTime;
	}

}

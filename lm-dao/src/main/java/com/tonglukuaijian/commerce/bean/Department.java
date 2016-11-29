package com.tonglukuaijian.commerce.bean;

import java.util.Date;

/**
 * 部门
 *
 * @author Lhy 2016年11月18日下午2:21:57
 */
public class Department {
	private Long id;
	private String name;
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

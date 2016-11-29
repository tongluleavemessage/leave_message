package com.tonglukuaijian.commerce.bean;

import java.util.Date;

/**
 * 项目成员
 *
 * @author Lhy 2016年11月29日上午10:08:55
 */
public class ProjectUser {
	private Long id;
	/**
	 * 项目ID
	 */
	private String projectId;
	/**
	 * 用户ID
	 */
	private Long userId;
	/**
	 * 创建时间
	 */
	private Date createdTime;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getProjectId() {
		return projectId;
	}

	public void setProjectId(String projectId) {
		this.projectId = projectId;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public Date getCreatedTime() {
		return createdTime;
	}

	public void setCreatedTime(Date createdTime) {
		this.createdTime = createdTime;
	}

}

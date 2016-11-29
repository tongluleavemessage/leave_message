package com.tonglukuaijian.commerce.bean;

import java.util.Date;

/**
 * 
 *
 * @author Lhy 2016年11月22日下午5:46:48
 */
public class Project {
	private Long id;
	/**
	 * 部门
	 */
	private Long departmentId;
	/**
	 * 部长用户ID
	 */
	private Long ministerUserId;
	/**
	 * 群总用户ID
	 */
	private Long groupUserId;
	private String projectId;
	private String projectName;
	/**
	 * 项目负责人ID
	 */
	private Long principalId;
	private Date createdTime;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getDepartmentId() {
		return departmentId;
	}

	public void setDepartmentId(Long departmentId) {
		this.departmentId = departmentId;
	}

	public Long getMinisterUserId() {
		return ministerUserId;
	}

	public void setMinisterUserId(Long ministerUserId) {
		this.ministerUserId = ministerUserId;
	}

	public Long getGroupUserId() {
		return groupUserId;
	}

	public void setGroupUserId(Long groupUserId) {
		this.groupUserId = groupUserId;
	}

	public String getProjectId() {
		return projectId;
	}

	public void setProjectId(String projectId) {
		this.projectId = projectId;
	}

	public String getProjectName() {
		return projectName;
	}

	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}

	public Long getPrincipalId() {
		return principalId;
	}

	public void setPrincipalId(Long principalId) {
		this.principalId = principalId;
	}

	public Date getCreatedTime() {
		return createdTime;
	}

	public void setCreatedTime(Date createdTime) {
		this.createdTime = createdTime;
	}

}

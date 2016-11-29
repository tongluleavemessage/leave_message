package com.tonglukuaijian.commerce.vo;

public class ProjectVo {
	private Long id;
	/**
	 * 部门ID
	 */
	private Long departmentId;
	/**
	 * 部长ID
	 */
	private Long ministerUserId;
	/**
	 * 群总ID
	 */
	private Long groupUserId;
	/**
	 * 项目ID
	 */
	private String projectId;
	/**
	 * 项目名称
	 */
	private String projectName;
	/**
	 * 项目负责人
	 */
	private Long principalId;

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

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
	

}

package com.tonglukuaijian.commerce.vo;

import javax.validation.constraints.NotNull;

public class ProjectVo {
	/**
	 * 部门ID
	 */
	@NotNull(message = "未指定部门")
	private Long departmentId;
	/**
	 * 部长ID
	 */
	@NotNull(message = "未指定部长")
	private Long ministerUserId;
	/**
	 * 群总ID
	 */
	@NotNull(message = "未指定群总")
	private Long groupUserId;
	/**
	 * 项目ID
	 */
	@NotNull(message = "请选择项目")
	private String projectId;
	/**
	 * 项目名称
	 */
	@NotNull(message = "项目名称不能为空")
	private String projectName;
	/**
	 * 项目负责人
	 */
	@NotNull(message = "未指定项目负责人")
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

}

package com.tonglukuaijian.commerce.vo;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * 留言
 *
 * @author Lhy 2016年11月7日下午2:46:12
 */
public class LeaveMessageVo {
	/**
	 * 姓名
	 */
	@NotNull(message = "姓名不能为空")
	private String name;
	/**
	 * 留言内容
	 */
	@NotNull(message = "留言内容不能为空")
	@Size(max = 200, message = "最多输入${max}个字")
	private String content;
	/**
	 * 手机号
	 */
	@NotNull(message = "手机号不能为空")
	private String phoneNum;

	/**
	 * 项目ID
	 */
	@NotNull(message = "项目不能为空")
	private String projectId;

	@NotNull(message = "项目名称不能为空")
	private String projectName;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getPhoneNum() {
		return phoneNum;
	}

	public void setPhoneNum(String phoneNum) {
		this.phoneNum = phoneNum;
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

}

package com.tonglukuaijian.commerce.bean;

import java.util.Date;

/**
 * 留言
 *
 * @author Lhy 2016年11月7日上午11:09:11
 */
public class LeaveMessage {
	private Long id;
	private String projectId;
	private String projectName;
	/**
	 * 客户姓名
	 */
	private String name;
	/**
	 * 客户手机号
	 */
	private String phoneNum;
	/**
	 * 内容
	 */
	private String content;
	/**
	 * 状态
	 */
	private Integer status;
	/**
	 * 创建时间
	 */
	private Date createdTime;

	/**
	 * 修改时间
	 */
	private Date modifyTime;

	/**
	 * 留言负责人
	 */
	private Long principal;

	/**
	 * 留言属于者
	 */
	private Long belongToUserId;

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

	public String getProjectName() {
		return projectName;
	}

	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhoneNum() {
		return phoneNum;
	}

	public void setPhoneNum(String phoneNum) {
		this.phoneNum = phoneNum;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
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

	public Date getModifyTime() {
		return modifyTime;
	}

	public void setModifyTime(Date modifyTime) {
		this.modifyTime = modifyTime;
	}

	public Long getPrincipal() {
		return principal;
	}

	public void setPrincipal(Long principal) {
		this.principal = principal;
	}

	public Long getBelongToUserId() {
		return belongToUserId;
	}

	public void setBelongToUserId(Long belongToUserId) {
		this.belongToUserId = belongToUserId;
	}

}

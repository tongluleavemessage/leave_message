package com.tonglukuaijian.commerce.bean;

import java.util.Date;
/**
 * 留言分派
 *
 * @author Lhy
 * 2016年11月21日上午9:35:49
 */
public class LeaveMessageAssignRecord {
	private Long id;
	/**
	 * 操作员
	 */
	private User operatorUser;

	private LeaveMessage leaveMessageId;
	/**
	 * 指定留言负责人
	 */
	private User assignUser;

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

	public User getOperatorUser() {
		return operatorUser;
	}

	public void setOperatorUser(User operatorUser) {
		this.operatorUser = operatorUser;
	}

	public LeaveMessage getLeaveMessageId() {
		return leaveMessageId;
	}

	public void setLeaveMessageId(LeaveMessage leaveMessageId) {
		this.leaveMessageId = leaveMessageId;
	}

	public User getAssignUser() {
		return assignUser;
	}

	public void setAssignUser(User assignUser) {
		this.assignUser = assignUser;
	}

	public Date getCreatedTime() {
		return createdTime;
	}

	public void setCreatedTime(Date createdTime) {
		this.createdTime = createdTime;
	}

}

package com.tonglukuaijian.commerce.vo;

public class LeaveMessageAssignVo {
	private Long leaveMessageAssignRecordId;
	/**
	 * 留言ID
	 */
	private Long leaveMessageId;
	/**
	 * 操作员ID
	 */
	private Long operatorUserId;
	/**
	 * 分配用户ID
	 */
	private Long assignUserId;

	public Long getLeaveMessageAssignRecordId() {
		return leaveMessageAssignRecordId;
	}

	public void setLeaveMessageAssignRecordId(Long leaveMessageAssignRecordId) {
		this.leaveMessageAssignRecordId = leaveMessageAssignRecordId;
	}

	public Long getLeaveMessageId() {
		return leaveMessageId;
	}

	public void setLeaveMessageId(Long leaveMessageId) {
		this.leaveMessageId = leaveMessageId;
	}

	public Long getOperatorUserId() {
		return operatorUserId;
	}

	public void setOperatorUserId(Long operatorUserId) {
		this.operatorUserId = operatorUserId;
	}

	public Long getAssignUserId() {
		return assignUserId;
	}

	public void setAssignUserId(Long assignUserId) {
		this.assignUserId = assignUserId;
	}

}

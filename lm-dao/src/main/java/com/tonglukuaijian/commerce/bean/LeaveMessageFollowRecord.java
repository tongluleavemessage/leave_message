package com.tonglukuaijian.commerce.bean;

import java.util.Date;

/**
 * 留言跟进状态
 *
 * @author Lhy 2016年11月18日下午3:03:07
 */
public class LeaveMessageFollowRecord {
	private Long id;

	/**
	 * 留言跟进操作员
	 */
	private Long operatorUserId;
	/**
	 * 留言
	 */
	private Long leaveMessageId;

	/**
	 * 操作时间
	 */
	private Date modifyTime;

	/**
	 * 状态
	 */
	private Integer status;

	/**
	 * 备注
	 */
	private String remark;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getOperatorUserId() {
		return operatorUserId;
	}

	public void setOperatorUserId(Long operatorUserId) {
		this.operatorUserId = operatorUserId;
	}

	public Long getLeaveMessageId() {
		return leaveMessageId;
	}

	public void setLeaveMessageId(Long leaveMessageId) {
		this.leaveMessageId = leaveMessageId;
	}

	public Date getModifyTime() {
		return modifyTime;
	}

	public void setModifyTime(Date modifyTime) {
		this.modifyTime = modifyTime;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

}

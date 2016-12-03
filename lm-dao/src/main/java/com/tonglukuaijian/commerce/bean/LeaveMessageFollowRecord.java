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
	 * 留言跟进操作员ID
	 */
	private Long operatorUserId;
	/**
	 * 留言跟进操作员
	 */
	private String operatorUserName;
	/**
	 * 留言
	 */
	private Long leaveMessageId;

	/**
	 * 回访时间
	 */
	private Date returnTime;

	/**
	 * 状态
	 */
	private Integer status;

	/**
	 * 备注
	 */
	private String remark;

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

	public Long getOperatorUserId() {
		return operatorUserId;
	}

	public void setOperatorUserId(Long operatorUserId) {
		this.operatorUserId = operatorUserId;
	}
	
	

	public String getOperatorUserName() {
		return operatorUserName;
	}

	public void setOperatorUserName(String operatorUserName) {
		this.operatorUserName = operatorUserName;
	}

	public Long getLeaveMessageId() {
		return leaveMessageId;
	}

	public void setLeaveMessageId(Long leaveMessageId) {
		this.leaveMessageId = leaveMessageId;
	}

	public Date getReturnTime() {
		return returnTime;
	}

	public void setReturnTime(Date returnTime) {
		this.returnTime = returnTime;
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

	public Date getCreatedTime() {
		return createdTime;
	}

	public void setCreatedTime(Date createdTime) {
		this.createdTime = createdTime;
	}

}

package com.tonglukuaijian.commerce.bean;

import java.util.Date;

/**
 * 留言跟进
 *
 * @author Lhy 2016年12月2日上午10:53:28
 */
public class LeaveMessageFollow {
	private Long id;
	private Long leaveMessageId;
	private Long operatorUserId;
	private Integer status;
	private String remark;
	private Date returnTime;
	private Date createdTime;
	private Date modifyTime;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	public Date getReturnTime() {
		return returnTime;
	}

	public void setReturnTime(Date returnTime) {
		this.returnTime = returnTime;
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
	

}

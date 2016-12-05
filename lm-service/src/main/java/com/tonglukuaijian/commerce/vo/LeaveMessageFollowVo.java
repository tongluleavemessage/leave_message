package com.tonglukuaijian.commerce.vo;

import java.util.Date;

/**
 * 留言跟进
 *
 * @author Lhy 2016年12月2日下午1:02:07
 */
public class LeaveMessageFollowVo {
	private Long leaveMessageId;
	private Long operatorUserId;
	private Integer status;
	private Date returnTime;
	private String remark;

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

	public Date getReturnTime() {
		return returnTime;
	}

	public void setReturnTime(Date returnTime) {
		this.returnTime = returnTime;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

}

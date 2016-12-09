package com.tonglukuaijian.commerce.vo;

import java.util.Date;

import javax.validation.constraints.NotNull;

/**
 * 留言跟进
 *
 * @author Lhy 2016年12月2日下午1:02:07
 */
public class LeaveMessageFollowVo {
	@NotNull(message = "未指定留言")
	private Long leaveMessageId;
	@NotNull(message = "未指定状态")
	private Integer status;
	@NotNull(message = "选择回访时间")
	private Date returnTime;
	private String remark;

	public Long getLeaveMessageId() {
		return leaveMessageId;
	}

	public void setLeaveMessageId(Long leaveMessageId) {
		this.leaveMessageId = leaveMessageId;
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

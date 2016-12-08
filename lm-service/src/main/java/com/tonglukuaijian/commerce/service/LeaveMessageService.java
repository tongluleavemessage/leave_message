package com.tonglukuaijian.commerce.service;

import java.util.Date;
import java.util.List;

import com.tonglukuaijian.commerce.bean.LeaveMessageAssignRecord;
import com.tonglukuaijian.commerce.bean.LeaveMessageFollow;
import com.tonglukuaijian.commerce.bean.LeaveMessageFollowRecord;
import com.tonglukuaijian.commerce.dto.LeaveMessageAssignRecordDto;
import com.tonglukuaijian.commerce.dto.LeaveMessageInfo;
import com.tonglukuaijian.commerce.out.OutMessage;
import com.tonglukuaijian.commerce.vo.LeaveMessageAssignVo;
import com.tonglukuaijian.commerce.vo.LeaveMessageFollowVo;
import com.tonglukuaijian.commerce.vo.LeaveMessageVo;

/**
 * 留言
 *
 * @author Lhy 2016年11月7日上午11:03:09
 */
public interface LeaveMessageService {

	/**
	 * 添加留言
	 */
	public OutMessage<?> addLeaveMessage(LeaveMessageVo vo);

	/**
	 * 根据条件获取留言
	 * 
	 * @param projectId
	 * @param projectName
	 * @param principalName
	 * @param principalPhone
	 * @param customerName
	 * @param status
	 * @param createdTime
	 * @param page
	 * @param size
	 * @return
	 */
	public OutMessage<?> getByParams(Long loginUserId, String projectId, String projectName, String principalName,
			String principalPhone, String customerName, Integer status, String createdTimeStart, String createdTimeEnd,
			int page, int size);

	/**
	 * 留言分派
	 * 
	 * @param vo
	 */
	public OutMessage<?> assignLeaveMessage(Long loginUserId, LeaveMessageAssignVo vo);

	/**
	 * 留言日志查看
	 * 
	 * @param projectId
	 * @param projectName
	 * @param projectPrincipal
	 * @param principalPhone
	 * @param customerName
	 * @param status
	 * @param createdTimeStart
	 * @param createdTimeEnd
	 * @param page
	 * @param size
	 * @return
	 */
	List<LeaveMessageAssignRecordDto> getLeaveMessageAssignRecordByParams(String projectId, String projectName,
			String projectPrincipal, String principalPhone, String customerName, Integer status,
			String createdTimeStart, String createdTimeEnd, int page, int size);

	/**
	 * 通过留言查询分派日志
	 * 
	 * @param leaveMessageId
	 * @return
	 */
	List<LeaveMessageAssignRecord> getLeaveMessageAssignRecord(Long leaveMessageId);

	/**
	 * 留言跟进
	 * 
	 * @param vo
	 */
	OutMessage<?> followLeaveMessage(LeaveMessageFollowVo vo);

	/**
	 * 获取留言跟进流水
	 * 
	 * @param leaveMessageId
	 * @param createdTime
	 * @return
	 */
	List<LeaveMessageFollowRecord> getFollowRecord(Long leaveMessageId, String createdTime);

	/**
	 * 留言详情
	 * 
	 * @param leaveMessageId
	 * @return
	 */
	LeaveMessageInfo getLeaveMessageInfo(Long loginUserId, Long leaveMessageId);

	/**
	 * 获取留言最新跟进
	 * 
	 * @param leaveMessageId
	 * @return
	 */
	LeaveMessageFollow getLeaveMessageFollowByLeaveMessageId(Long loginUserId, Long leaveMessageId);

	/**
	 * 获取留言分派记录
	 * 
	 * @param id
	 * @return
	 */
	LeaveMessageAssignRecord getLeaveMessageAssignRecordById(Long id);

	/**
	 * 留言任务
	 * 
	 * @param now
	 */
	void leaveMessageJob(Date now);
}

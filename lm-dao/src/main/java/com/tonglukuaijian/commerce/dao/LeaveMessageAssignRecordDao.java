package com.tonglukuaijian.commerce.dao;

import java.util.List;

import com.tonglukuaijian.commerce.bean.LeaveMessageAssignRecord;
import com.tonglukuaijian.commerce.dto.LeaveMessageAssignRecordDto;

public interface LeaveMessageAssignRecordDao {
	/**
	 * 保存
	 * 
	 * @param po
	 */
	public void save(LeaveMessageAssignRecord po);

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
	List<LeaveMessageAssignRecordDto> findByParams(String projectId, String projectName, String projectPrincipal,
			String principalPhone, String customerName, Integer status, String createdTimeStart, String createdTimeEnd,
			int page, int size);

	/**
	 * 查询留言分配记录
	 * 
	 * @param leaveMessageId
	 * @return
	 */
	List<LeaveMessageAssignRecord> findByLeaveMessageId(Long leaveMessageId);

	/**
	 * 根据ID 查询跟进流水
	 * 
	 * @param id
	 * @return
	 */
	LeaveMessageAssignRecord findById(Long id);
}

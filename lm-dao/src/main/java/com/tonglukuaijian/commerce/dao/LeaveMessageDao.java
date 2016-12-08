package com.tonglukuaijian.commerce.dao;

import java.util.List;

import com.tonglukuaijian.commerce.bean.LeaveMessage;
import com.tonglukuaijian.commerce.dto.LeaveMessageInfo;

public interface LeaveMessageDao {
	/**
	 * 添加留言
	 */
	public void saveLeaveMesage(LeaveMessage leaveMessage);



	/**
	 * 留言查找
	 * 
	 * @param id
	 * @return
	 */
	LeaveMessage findById(Long id);

	/**
	 * 留言查询
	 * 
	 * @param principalUserId
	 *            留言负责人
	 * @param beLongUserId
	 *            留言所属者
	 * @param projectId
	 * @param projectName
	 * @param principalName
	 * @param principalPhone
	 * @param customerName
	 * @param status
	 * @param createdTimeStart
	 * @param createdTimeEnd
	 * @param page
	 * @param size
	 * @return
	 */
	List<LeaveMessageInfo> findByParams(Long principalUserId, String beLongUserId, String projectId, String projectName,
			String principalName, String principalPhone, String customerName, String status, String createdTimeStart,
			String createdTimeEnd, int page, int size);

	/**
	 * 根据状态查询留言
	 * 
	 * @param status
	 * @return
	 */
	List<LeaveMessage> findByStatus(String status);

	/**
	 * 留言修改
	 * 
	 * @param leaveMessage
	 */
	void updateLeaveMesage(LeaveMessage leaveMessage);
}

package com.tonglukuaijian.commerce.dao;

import java.util.List;

import com.tonglukuaijian.commerce.bean.LeaveMessageFollow;
import com.tonglukuaijian.commerce.bean.LeaveMessageFollowRecord;

public interface LeaveMessageFollowDao {
	/**
	 * 跟进添加
	 * 
	 * @param po
	 */
	public void save(LeaveMessageFollow po);

	/**
	 * 修改跟进
	 * 
	 * @param po
	 */
	public void update(LeaveMessageFollow po);

	/**
	 * 根据留言获取最新跟进记录
	 * 
	 * @param leaveMessageId
	 * @return
	 */
	LeaveMessageFollow findByleaveMessageId(Long leaveMessageId);

	/**
	 * 保存跟进记录
	 * 
	 * @param po
	 */
	public void saveFollowRecord(LeaveMessageFollowRecord po);

	/**
	 * 跟进流水
	 * 
	 * @param LeaveMessageId
	 * @param createdTime
	 * @return
	 */
	List<LeaveMessageFollowRecord> findFollowRecord(Long leaveMessageId, String createdTime);

}

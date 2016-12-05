package com.tonglukuaijian.commerce.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.tonglukuaijian.commerce.bean.LeaveMessageFollow;
import com.tonglukuaijian.commerce.bean.LeaveMessageFollowRecord;
import com.tonglukuaijian.commerce.dao.LeaveMessageFollowDao;
import com.tonglukuaijian.commerce.mapper.LeaveMessageFollowMapper;
import com.tonglukuaijian.commerce.mapper.LeaveMessageFollowRecordMapper;

@Repository
public class LeaveMessageFollowDaoImpl implements LeaveMessageFollowDao {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public void save(LeaveMessageFollow po) {
		jdbcTemplate.update(
				"insert into T_LEAVE_MESSAGE_FOLLOW (LEAVE_MESSAGE_ID,OPERATOR_USER_ID,STATUS,REMARK,RETURN_TIME,CREATED_TIME,MODIFY_TIME) values(?,?,?,?,?,?,?)",
				new Object[] { po.getLeaveMessageId(), po.getOperatorUserId(), po.getStatus(), po.getRemark(),
						po.getReturnTime(), po.getCreatedTime(), po.getModifyTime() });
	}

	@Override
	public void update(LeaveMessageFollow po) {
		jdbcTemplate.update(
				"UPDATE T_LEAVE_MESSAGE_FOLLOW SET STATUS=?,REMARK=?,OPERATOR_USER_ID=?,RETURN_TIME=?,MODIFY_TIME=? WHERE LEAVE_MESSAGE_ID=?",
				new Object[] { po.getStatus(), po.getRemark(), po.getOperatorUserId(), po.getReturnTime(),
						po.getModifyTime(), po.getLeaveMessageId() });
	}

	@Override
	public LeaveMessageFollow findByleaveMessageId(Long leaveMessageId) {
		return jdbcTemplate.queryForObject(
				"SELECT * FROM T_LEAVE_MESSAGE_FOLLOW WHERE LEAVE_MESSAGE_ID=" + leaveMessageId,
				new LeaveMessageFollowMapper());
	}

	@Override
	public void saveFollowRecord(LeaveMessageFollowRecord po) {
		jdbcTemplate.update(
				"INSERT INTO T_LEAVE_MESSAGE_FOLLOW_RECORD (OPERATOR_USER_ID,OPERATOR_USER_NAME,LEAVE_MESSAGE_ID,RETURN_TIME,STATUS,REMARK,CREATED_TIME) values(?,?,?,?,?,?,?)",
				new Object[] { po.getOperatorUserId(), po.getOperatorUserName(), po.getLeaveMessageId(),
						po.getReturnTime(), po.getStatus(), po.getRemark(), po.getCreatedTime() });
	}

	@Override
	public List<LeaveMessageFollowRecord> findFollowRecord(Long leaveMessageId, String createdTime) {
		String sql = "SELECT * FROM T_LEAVE_MESSAGE_FOLLOW_RECORD WHERE 1=1";
		if (null != leaveMessageId) {
			sql += " and LEAVE_MESSAGE_ID=" + leaveMessageId;
		}
		if (null != createdTime) {
			sql += " and CREATED_TIME<=" + createdTime;
		}
		List<LeaveMessageFollowRecord> list = jdbcTemplate.query(sql, new LeaveMessageFollowRecordMapper());
		return list;

	}

}

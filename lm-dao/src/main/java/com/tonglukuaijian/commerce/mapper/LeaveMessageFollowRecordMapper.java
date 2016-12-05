package com.tonglukuaijian.commerce.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.tonglukuaijian.commerce.bean.LeaveMessageFollowRecord;

public class LeaveMessageFollowRecordMapper implements RowMapper<LeaveMessageFollowRecord> {

	@Override
	public LeaveMessageFollowRecord mapRow(ResultSet rs, int arg1) throws SQLException {
		LeaveMessageFollowRecord po=new LeaveMessageFollowRecord();
		po.setCreatedTime(rs.getDate("CREATED_TIME"));
		po.setId(rs.getLong("ID"));
		po.setLeaveMessageId(rs.getLong("LEAVE_MESSAGE_ID"));
		po.setOperatorUserId(rs.getLong("OPERATOR_USER_ID"));
		po.setOperatorUserName(rs.getString("OPERATOR_USER_NAME"));
		po.setRemark(rs.getString("REMARK"));
		po.setReturnTime(rs.getDate("RETURN_TIME"));
		po.setStatus(rs.getInt("STATUS"));
		return null;
	}

}

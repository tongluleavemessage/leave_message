package com.tonglukuaijian.commerce.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.tonglukuaijian.commerce.bean.LeaveMessageAssignRecord;

public class LeaveMessageAssignRecordMapper implements RowMapper<LeaveMessageAssignRecord> {

	@Override
	public LeaveMessageAssignRecord mapRow(ResultSet rs, int arg1) throws SQLException {
		LeaveMessageAssignRecord po = new LeaveMessageAssignRecord();
		po.setAssignUserPhoneNum(rs.getString("ASSIGN_USER_PHONE"));
		po.setAssignUserAccountNumber(rs.getString("ASSIGN_USER_ACCOUNT_NUMBER"));
		po.setAssignUserName(rs.getString("ASSIGN_USER_NAME"));
		po.setAssignRoleName(rs.getString("ASSIGN_USER_ROLE_NAME"));
		po.setCreatedTime(rs.getTimestamp("CREATED_TIME"));
		po.setId(rs.getLong("ID"));
		po.setLeaveMessageId(rs.getLong("LEAVE_MESSAGE_ID"));
		po.setLeaveMessageStatus(rs.getInt("LEAVE_MESSAGE_STATUS"));
		po.setOperatorUserPhone(rs.getString("OPERATOR_USER_PHONE"));
		po.setOperatorRoleName(rs.getString("OPERATOR_ROLE_NAME"));
		po.setOperatorUserName(rs.getString("OPERATOR_USER_NAME"));
		return null;
	}

}

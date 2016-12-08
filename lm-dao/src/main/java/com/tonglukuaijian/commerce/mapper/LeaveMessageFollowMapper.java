package com.tonglukuaijian.commerce.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.tonglukuaijian.commerce.bean.LeaveMessageFollow;

public class LeaveMessageFollowMapper implements RowMapper<LeaveMessageFollow> {

	@Override
	public LeaveMessageFollow mapRow(ResultSet rs, int arg1) throws SQLException {
		LeaveMessageFollow po = new LeaveMessageFollow();
		po.setCreatedTime(rs.getTimestamp("CREATED_TIME"));
		po.setId(rs.getLong("ID"));
		po.setLeaveMessageId(rs.getLong("LEAVE_MESSAGE_ID"));
		po.setModifyTime(rs.getTimestamp("MODIFY_TIME"));
		po.setOperatorUserId(rs.getLong("OPERATOR_USER_ID"));
		po.setRemark(rs.getString("REMARK"));
		po.setReturnTime(rs.getTimestamp("RETURN_TIME"));
		po.setStatus(rs.getInt("STATUS"));
		return po;

	}

}

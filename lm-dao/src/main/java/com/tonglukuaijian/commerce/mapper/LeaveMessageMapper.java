package com.tonglukuaijian.commerce.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.tonglukuaijian.commerce.bean.LeaveMessage;

public class LeaveMessageMapper implements RowMapper<LeaveMessage> {

	@Override
	public LeaveMessage mapRow(ResultSet rs, int arg1) throws SQLException {
		LeaveMessage po = new LeaveMessage();
		po.setBelongToUserId(rs.getLong("BELONGTO_USER_ID"));
		po.setContent(rs.getString("CONTENT"));
		po.setId(rs.getLong("ID"));
		po.setModifyTime(rs.getTimestamp("MODIFY_TIME"));
		po.setName(rs.getString("NAME"));
		po.setPhoneNum(rs.getString("PHONE_NUM"));
		po.setPrincipal(rs.getLong("PRINCIPAL_USER_ID"));
		po.setProjectId(rs.getString("PROJECT_ID"));
		po.setProjectName(rs.getString("PROJECT_NAME"));
		po.setStatus(rs.getInt("STATUS"));
		return po;
	}

}

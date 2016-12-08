package com.tonglukuaijian.commerce.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.tonglukuaijian.commerce.dto.LeaveMessageInfo;

public class LeaveMessageDtoMapper implements RowMapper<LeaveMessageInfo> {

	@Override
	public LeaveMessageInfo mapRow(ResultSet rs, int arg1) throws SQLException {
		LeaveMessageInfo po=new LeaveMessageInfo();
		po.setId(rs.getLong("ID"));
		po.setProjectId(rs.getString("PROJECT_ID"));
		po.setProjectName(rs.getString("PROJECT_NAME"));
		po.setProjectPrincipalUserName(rs.getString("PRINCIPAL"));
		po.setPrincipalPhoneNum(rs.getString("PRINCIPAL_PHONE"));
		po.setCustomerName(rs.getString("CUSTOMER_NAME"));
		po.setCustomerPhone(rs.getString("CUSTOMER_PHONE"));
		po.setContent(rs.getString("CONTENT"));
		po.setStatus(rs.getInt("STATUS"));
		po.setCreatedTime(rs.getTimestamp("CREATED_TIME"));
		po.setLeaveMessagePrincipalUserId(rs.getLong("PRINCIPAL_USER_ID"));
		return po;
	}

}

package com.tonglukuaijian.commerce.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.tonglukuaijian.commerce.dto.LeaveMessageAssignRecordDto;

public class LeaveMessageAssignRecordDtoMapper implements RowMapper<LeaveMessageAssignRecordDto>{

	@Override
	public LeaveMessageAssignRecordDto mapRow(ResultSet rs, int arg1) throws SQLException {
		LeaveMessageAssignRecordDto po=new LeaveMessageAssignRecordDto();
		po.setId(rs.getLong("ID"));
		po.setProjectId(rs.getString("PROJECT_ID"));
		po.setProjectName(rs.getString("PROJECT_NAME"));
		po.setCustomerName(rs.getString("CUSTOMER_NAME"));
		po.setStatus(rs.getInt("LEAVE_MESSAGE_STATUS"));
		po.setLeaveMessageTime(rs.getDate("LEAVE_MESSAGE_CREATED_TIME"));
		po.setProjectPrincipalName(rs.getString("PROJECT_PRINCIPAL_NAME"));
		po.setPrincipalPhoneNum(rs.getString("PHONE_NUM"));
		po.setOperatorName(rs.getString("OPERATOR_USER_NAME"));
		po.setOperatorRoleName(rs.getString("OPERATOR_ROLE_NAME"));
		po.setAssignToUserName(rs.getString("ASSIGN_USER_NAME"));
		po.setAssignTime(rs.getDate("CREATED_TIME"));
		return po;
		
	}

}

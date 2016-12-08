package com.tonglukuaijian.commerce.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;

import org.springframework.jdbc.core.RowMapper;

import com.tonglukuaijian.commerce.dto.UserDto;

public class UserDtoMapper implements RowMapper<UserDto> {

	@Override
	public UserDto mapRow(ResultSet rs, int arg1) throws SQLException {
		UserDto dto = new UserDto();
		dto.setId(rs.getLong("ID"));
		dto.setAccountNumber(rs.getString("ACCOUNT_NUMBER"));
		dto.setName(rs.getString("NAME"));
		dto.setPhoneNum(rs.getString("PHONE_NUM"));
		dto.setDepartmentId(rs.getLong("DEPARTMENT_ID"));
		dto.setDepartmentName(rs.getString("DEPATRMENTNAME"));
		dto.setRoleId(rs.getLong("ROLE_ID"));
		dto.setRoleName(rs.getString("ROLENAME"));
		dto.setStatus(rs.getInt("STATUS"));
		dto.setCreatedTime(rs.getTimestamp("CREATED_TIME"));
		dto.setLoginTime(rs.getTimestamp("LOGIN_TIME"));
		return dto;
	}

}
